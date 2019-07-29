package introspectionabstractclass.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "expected_payment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FooAccountingEntry extends AccountingEntry {

    public FooAccountingEntry(Account account, BigDecimal amount) {
        super(account, amount);
    }
}
