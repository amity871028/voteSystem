package esun.voteSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.persistence.IdClass;

@Entity
@Table(name = "record")
@IdClass(VoterItemId.class)
public class Record {
	
	@Id
    private String voter;
	@Id
    private int itemId;
    

//    @ManyToOne
//    @JoinColumn(name = "itemId")
//    private Item item;


	public String getVoter() {
		return voter;
	}


	public void setVoter(String voter) {
		this.voter = voter;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

//
//	public Item getItem() {
//		return item;
//	}
//
//
//	public void setItem(Item item) {
//		this.item = item;
//	}
    
    
}

