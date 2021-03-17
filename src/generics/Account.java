package generics;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account<T,S> {

    private T id;
    private S sum;

    public void changeInfo(T id, S sum) {
        this.id = id;
        this.sum = sum;
    }
}
