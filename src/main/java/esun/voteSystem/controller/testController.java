package esun.voteSystem.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import esun.voteSystem.repository.ItemRepository;
import esun.voteSystem.repository.RecordRepository;
import esun.voteSystem.dto.VoteItemResult;
import esun.voteSystem.model.Item;
import esun.voteSystem.model.Record;

@RestController
public class testController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private RecordRepository recordRepository;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
    
    // 頁面顯示所有投票項目
    @GetMapping("/item")
    public List<Item> getAllItem() {
      return itemRepository.findAll();
    }
    
    // 可新增投票項目
    @PostMapping("/addItemName")
    public void addItemName(@RequestBody Item itemRequest) {
    	Item newItem = new Item();
    	newItem.setId(itemRequest.getId());
    	newItem.setName(itemRequest.getName());
    	itemRepository.save(newItem);
    }
    
    // 頁面顯示所有可投票項目和其目前累積票數
    @GetMapping("/itemResult")
    public List<VoteItemResult> getAllItemResult() {
      List<Item> allItem = itemRepository.findAll();
      List<Object[]> resultObject = recordRepository.calculateTotalVotesForItems();
      List<VoteItemResult> result = null;
//      for (Object[] each : resultObject) {
//    	 System.out.println(each[0]);
//    	 VoteItemResult tmpVoteItem = new VoteItemResult();
//    	 
//    	 tmpVoteItem.setItemId((int) each[0]);
//    	 tmpVoteItem.setTotalVote((int) each[1]);
//    	 result.add(tmpVoteItem);
//      }
      return result;
//      List<>
    }    

    // 可新增投票項目
    @PostMapping("/vote")
    public void vote(@RequestBody List<Record> recordRequest) {
		recordRepository.saveAll(recordRequest);
    		

    }
    
    public static List<?> convertObjectToList(Object obj) {
        List<?> list = new ArrayList<>();
        if (obj.getClass().isArray()) {
            list = Arrays.asList((Object[])obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<?>)obj);
        }
        return list;
    }
}
