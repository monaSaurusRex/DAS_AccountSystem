package za.ac.nwu.das.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "account_transaction"/*, schema = "proj1_das_demo"*/)
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 6926049907460965566L;

    private Long transactionId;
    //private Long accountTypeId;
    private AccountType accountType;
    private Long memberId;
    private Long transactionAmt;
    private LocalDate transactionDate;


    public AccountTransaction() {
    }

    public AccountTransaction(Long transactionId, /*Long accountTypeId,*/ AccountType accountType, Long memberId, Long transactionAmt, LocalDate transactionDate) {
        this.transactionId = transactionId;
        //this.accountTypeId = accountTypeId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.transactionAmt = transactionAmt;
        this.transactionDate = transactionDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    public Long getTransactionId() {
        return transactionId;
    }

//    @Column(name = "account_type_id")
//    public Long getAccountTypeId() {
//        return accountTypeId;
//    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_type_id")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Column(name = "member_id")
    public Long getMemberId() {
        return memberId;
    }

    @Column(name = "transaction_amount")
    public Long getTransactionAmt() {
        return transactionAmt;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setTransactionAmt(Long transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) /*&& Objects.equals(accountType, that.accountType)*/ && Objects.equals(memberId, that.memberId) && Objects.equals(transactionAmt, that.transactionAmt) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, /*accountTypeId,*/ accountType, memberId, transactionAmt, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                //", accountTypeId=" + accountTypeId +
                ", accountType=" + accountType +
                ", memberId=" + memberId +
                ", transactionAmt=" + transactionAmt +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
