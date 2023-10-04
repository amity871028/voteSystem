package esun.voteSystem.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import esun.voteSystem.model.Record;
import esun.voteSystem.model.VoterItemId;
import esun.voteSystem.dto.VoteItemResult;

@Repository
public interface RecordRepository extends JpaRepository<Record, VoterItemId>{
    // 計算每個投票項目的總票數
//	@Query("SELECT new esun.voteSystem.dto.VoteItemResult(vr.itemId, SUM(vr.*) AS totalVote) " +
//	           "FROM result AS vr GROUP BY vr.itemId")
    @Query(nativeQuery = true, value = "SELECT itemId, count(*) as totalVote " +
           "FROM record GROUP BY itemId")
    List<Object[]> calculateTotalVotesForItems();
//	@Query(nativeQuery = true,value = "SELECT voter FROM record")
//	List<String> testt();
}
