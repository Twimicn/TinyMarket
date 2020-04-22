package cn.ivanlu.market.service;

import cn.ivanlu.market.common.ApiResponse;
import cn.ivanlu.market.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    ApiResponse<Void> addCategory(String name, long pid);

    ApiResponse<Void> editCategory(long id, String name);

    int count();

    List<Category> listByPage(int page, int size);

    int countByPid(long pid);

    List<Category> listByPidAndPage(long pid, int page, int size);
}
