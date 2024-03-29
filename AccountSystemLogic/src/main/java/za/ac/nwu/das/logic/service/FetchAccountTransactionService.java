package za.ac.nwu.das.logic.service;

import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import java.util.List;

public interface FetchAccountTransactionService {

    List<AccountTransactionDto> getAllTransactions();

    AccountTransactionDto getTransactionById(Long transactionId);

    Long getTotalValueOfMnemonic(String mnemonic);

}
