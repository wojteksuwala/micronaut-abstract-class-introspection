package introspectionabstractclass.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private String policyNumber;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<AccountingEntry> entries;

    public Account(String number) {
        this.policyNumber= number;
        this.entries = new ArrayList<>();
    }

    public void addFoo(BigDecimal amount) {
        entries.add(new FooAccountingEntry(this, amount));
    }

}
