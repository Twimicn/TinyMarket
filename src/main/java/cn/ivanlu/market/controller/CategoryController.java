package cn.ivanlu.market.controller;

import cn.ivanlu.market.annotation.Permission;
import cn.ivanlu.market.common.ApiResponse;
import cn.ivanlu.market.common.PageData;
import cn.ivanlu.market.model.Category;
import cn.ivanlu.market.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Permission("admin")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<Void> addCategory(@RequestParam String name, @RequestParam(required = false, defaultValue = "0") long pid) {
        return categoryService.addCategory(name, pid);
    }

    @Permission("admin")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<Void> editCategory(@RequestParam long id, @RequestParam String name) {
        return categoryService.editCategory(id, name);
    }

    @Permission("admin")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<PageData<Category>> apiList(
            @RequestParam(name = "pid", required = false, defaultValue = "0") long pid,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        PageData<Category> pageData = PageData.<Category>builder()
                .list(categoryService.listByPidAndPage(pid, page, size)).page(page)
                .total(categoryService.countByPid(pid))
                .build();
        return ApiResponse.<PageData<Category>>builder().status(0).msg("ok").data(pageData).build();
    }
}
