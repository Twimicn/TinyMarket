package cn.ivanlu.market.service.impl;

import cn.ivanlu.market.common.ApiResponse;
import cn.ivanlu.market.dao.CategoryDao;
import cn.ivanlu.market.model.Category;
import cn.ivanlu.market.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public ApiResponse<Void> addCategory(String name, long pid) {
        Category category = Category.builder().name(name).parentId(pid).createTime(new Date()).build();
        long id = categoryDao.create(category);
        if (id > 0) {
            return ApiResponse.<Void>builder().msg("ok").status(0).build();
        } else {
            return ApiResponse.<Void>builder().status(-6).msg("数据库出错").build();
        }
    }

    @Override
    public ApiResponse<Void> editCategory(long id, String name) {
        if (categoryDao.updateName(id, name) > 0) {
            return ApiResponse.<Void>builder().msg("ok").status(0).build();
        } else {
            return ApiResponse.<Void>builder().status(-6).msg("数据库出错").build();
        }
    }

    @Override
    public int count() {
        return categoryDao.count();
    }

    @Override
    public List<Category> listByPage(int page, int size) {
        return categoryDao.listByPage((page - 1) * size, size);
    }

    @Override
    public int countByPid(long pid) {
        return categoryDao.countByPid(pid);
    }

    @Override
    public List<Category> listByPidAndPage(long pid, int page, int size) {
        return categoryDao.listByPidAndPage(pid, (page - 1) * size, size);
    }
}
