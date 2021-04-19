package com.example.service.impl;



import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.domain.PageBean;
import com.example.service.UserService;
import com.example.domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }
    public User login(User user){
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    public void addUser(User user){
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void deleteSelectedUser(String[] ids) {
        if(ids!=null && ids.length>0) {
            for (String id : ids) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        PageBean<User> pb=new PageBean<User>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        int totalCount=dao.findTotalCount();
        pb.setTotalCount(totalCount);
        int start=(currentPage-1)*rows;
        List<User> list=dao.findByPage(start,rows);
        //dao.findByPage(start,rows);
        pb.setList(list);

        int totalPage=totalCount%rows==0 ? totalCount/rows:totalCount/rows+1;
        pb.setTotalPage(totalPage);
        return pb;
    }


}
