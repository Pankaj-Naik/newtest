package org.bluepigeon.admin.service;

import java.util.List;

import org.bluepigeon.admin.dao.StateImp;
import org.bluepigeon.admin.exception.ResponseMessage;
import org.bluepigeon.admin.model.State;


public class StateService  {

    public ResponseMessage addState(State state)
    {
        StateImp stateDAO = new StateImp();        
        return stateDAO.save(state);
    }
    
    public ResponseMessage updateState(State state)
    {
        StateImp stateDAO = new StateImp();            
        return stateDAO.update(state);
    }
    
    public List<State> getAllStates()
    {
        StateImp stateDAO = new StateImp();        
        return stateDAO.getStateList();
    }
    
    public List<State> getAllStatesByCountryId(int countryId)
    {
        StateImp stateDAO = new StateImp();        
        return stateDAO.getStateByCountryId(countryId);
    }
    
    public List<State> getStateDetailById(int id)
    {
        StateImp stateDAO = new StateImp();        
        return stateDAO.getStateById(id);
    }

}