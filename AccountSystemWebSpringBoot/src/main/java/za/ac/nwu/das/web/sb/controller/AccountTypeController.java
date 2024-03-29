package za.ac.nwu.das.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.das.domain.dto.AccountTypeDto;
import za.ac.nwu.das.domain.service.GeneralResponse;
import za.ac.nwu.das.logic.service.CreateAccountTypeService;
import za.ac.nwu.das.logic.service.FetchAccountTypeService;

import java.util.List;

@RestController
@RequestMapping("account-type")
public class AccountTypeController {

    private final FetchAccountTypeService fetchAccountTypeService;
    private final CreateAccountTypeService createAccountTypeService;

    //LOGGING
    public static final Logger LOGGER = LoggerFactory.getLogger(AccountTypeController.class);

    @Autowired
    public AccountTypeController(FetchAccountTypeService fetchAccountTypeService,
                                 CreateAccountTypeService createAccountTypeService){

        this.fetchAccountTypeService = fetchAccountTypeService;
        this.createAccountTypeService = createAccountTypeService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account Types.", notes = "Returns a list of account types.")
    @ApiResponses(value ={
                  @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
                  @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                  @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
                  @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll(){

        long startTime = System.nanoTime();
        LOGGER.debug("Get list of AccountTypes from DB");

        List<AccountTypeDto> accountTypes = fetchAccountTypeService.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        ResponseEntity<GeneralResponse<List<AccountTypeDto>>> generalResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        LOGGER.info("Response time {}", (System.nanoTime() - startTime)/1000000L);

        return generalResponseEntity;


    }

    @GetMapping("/{mnemonic}")
    @ApiOperation(value = "Fetches a specific AccountType", notes = "Fetches the AccountType corresponding to the given mnemonic.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountType Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "AccountType Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getByMnemonic(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable ("mnemonic") final String mnemonic){

        long startTime = System.nanoTime();
        LOGGER.debug("Get AccountTypes from DB by mnemonic");

        AccountTypeDto accountType = fetchAccountTypeService.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
        ResponseEntity<GeneralResponse<AccountTypeDto>> generalResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        LOGGER.info("Response time {}", (System.nanoTime() - startTime)/1000000L);

        return generalResponseEntity;
    }


    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType", notes = "Creates a new AccountType in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType was created succesfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new Account Type.", required = true)
            @RequestBody AccountTypeDto accountType){

        long startTime = System.nanoTime();
        LOGGER.debug("Create new AccountType");

        AccountTypeDto accountTypeResponse = createAccountTypeService.createAccountType(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        ResponseEntity<GeneralResponse<AccountTypeDto>> generalResponseEntity = new ResponseEntity<>(response, HttpStatus.CREATED);

        LOGGER.info("Response time {}", (System.nanoTime() - startTime)/1000000L);

        return generalResponseEntity;
    }

}


