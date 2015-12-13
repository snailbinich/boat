package com.izhaoyan.parrot.component;

import java.util.List;

/**
 * Created by zhaoyan on 15-12-13.
 */
public class Pager<T>  {

    public int totalItems;
    public int pageSize;
    public int currentPage;
    public String order;
    public List<T> data;


}
