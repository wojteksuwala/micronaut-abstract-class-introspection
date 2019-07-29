package introspectionabstractclass.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance
@Table(name = "accounting_entry")
@DiscriminatorColumn(name = "entry_type")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class AccountingEntry {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "amount")
    private BigDecimal amount;

    public AccountingEntry(Account account, BigDecimal amount) {
        this.account = account;
        this.amount = amount;
    }
}
