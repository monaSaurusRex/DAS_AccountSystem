package za.ac.nwu.das.translator;

import za.ac.nwu.das.domain.dto.AccountTypeDto;
import java.util.List;

public interface AccountTypeTranslator {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto create(AccountTypeDto accountType);



}
