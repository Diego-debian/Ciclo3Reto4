package com.diegoparra.ciclo3.reto3.service;

import com.diegoparra.ciclo3.reto3.model.Category;
import com.diegoparra.ciclo3.reto3.model.Message;
import com.diegoparra.ciclo3.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    public List<Message> getAll(){
        return (List<Message>) messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message m){
        if(m.getIdMessage()== null){
            return messageRepository.save(m);
        }
        else {
            Optional<Message> paux=messageRepository.getMessage(m.getIdMessage());
            if (paux.isEmpty()){
                return messageRepository.save(m);
            }
            else {
                return m;
            }
        }
    }

    public Message update(Message c){
        if(c.getIdMessage()!=null){
            Optional<Message> g= messageRepository.getMessage(c.getIdMessage());
            if(!g.isEmpty()){
                if (c.getMessageText()!=null){
                    g.get().setMessageText(c.getMessageText());
                }
                return messageRepository.save(g.get());
            }
        }
        return c;
    }
    public boolean deleteMessage(int id){
        Optional<Message> c = getMessage(id);
        if (!c.isEmpty()){
            messageRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
