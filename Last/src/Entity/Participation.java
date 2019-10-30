/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author asus
 */
public class Participation {

    private int id;
    private int paticipant_id;
    private int event_id;

    public Participation(int id, int paticipant_id, int event_id) {
        this.id = id;
        this.paticipant_id = paticipant_id;
        this.event_id = event_id;
    }

    public Participation(int paticipant_id, int event_id) {
        this.paticipant_id = paticipant_id;
        this.event_id = event_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaticipant_id() {
        return paticipant_id;
    }

    public void setPaticipant_id(int paticipant_id) {
        this.paticipant_id = paticipant_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    
    
    

}
