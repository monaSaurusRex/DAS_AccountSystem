package za.ac.nwu.das.repo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.persistence.AccountTransaction;

import java.util.List;

@Repository
public interface AccountTransactionRepo extends JpaRepository<AccountTransaction, Long> {

//    @Query(value = "SELECT " +
//            "           actx, acct " +
//            "       FROM " +
//            "           AccountTransaction actx, AccountType acct " +
//            "       WHERE acct.mnemonic = :mnemonic ")
//    List<AccountTransactionDto> getAllAccountTypeTransactions(String mnemonic);

}