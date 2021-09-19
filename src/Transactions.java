import java.math.BigDecimal;

public abstract interface Transactions {

    public abstract BigDecimal calculate(BigDecimal balance, BigDecimal interest);

}

class Interest implements Transactions {

    @Override
    public BigDecimal calculate(BigDecimal balance, BigDecimal interest) {
        return balance.multiply(interest.add(BigDecimal.valueOf(1)));
    }

}

class Fees implements Transactions {

    @Override
    public BigDecimal calculate(BigDecimal balance, BigDecimal fees) {
        return balance.subtract(fees);
    }

}

class Bonus implements Transactions {

    @Override
    public BigDecimal calculate(BigDecimal balance, BigDecimal bonus) {
        return balance.add(bonus);
    }

}