package com.example;


import java.util.List;

public interface PBDAO {
   public List<PBVO> getList();
   public List<PBVO> search(String keyword);
   public int insert(PBVO vo);
   public int delete(Long pk);

}
