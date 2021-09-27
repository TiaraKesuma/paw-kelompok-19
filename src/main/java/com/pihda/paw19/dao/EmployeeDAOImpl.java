package com.pihda.paw19.dao;

import com.pihda.paw19.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // need to inject the session factory
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getEmployees() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name

        // execute query and get result list

        // return the results
        return currentSession.createQuery("from Employee order by lastName",
                Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee theEmployee) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/update the employee ... finally LOL
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public Employee getEmployee(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Employee theEmployee = currentSession.get(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public void deleteEmployee(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();
    }

}










