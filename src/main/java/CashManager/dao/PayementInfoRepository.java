package CashManager.dao;

import CashManager.models.payement.PayementInfo;
import CashManager.models.payement.PayementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayementInfoRepository extends JpaRepository<PayementInfo,Integer> {


}
