package com.xdcplus.xdcweb.global.utils;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageInfo;
import com.xdcplus.xdcweb.global.pojo.vo.PageVO;

/**
 * 属性工具类
 * @author Rong.Jia
 * @date 2020/01/14 09:22
 */
public class PropertyUtils {

    /**
     *  page 转vo 对象
     * @param page   分页查询结果对象
     * @param pageVO 分页查询结果vo对象
     * @date 2019/07/02 11:13:22
     * @author Rong.Jia
     */
    public static void copyProperties(PageInfo<?> page, PageVO<?> pageVO) {

        pageVO.setTotalPages(Convert.toLong(page.getPages()));
        pageVO.setHasNext(page.isHasNextPage());
        pageVO.setHasPrevious(page.isHasPreviousPage());
        pageVO.setIsFirst(page.isIsFirstPage());
        pageVO.setIsLast(page.isIsLastPage());
        pageVO.setTotal(Convert.toLong(page.getTotal()));
        pageVO.setCurrentPage(page.getPageNum());
        pageVO.setPageSize(page.getSize());

    }

}
