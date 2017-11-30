package utility.validation;

import java.util.function.Predicate;

public class IOValidation<K> implements Validation<K> {

    private final Predicate<K> predicate;
    private final String onErrorMessage;

    public static <K> IOValidation<K> from(Predicate<K> predicate, String onErrorMessage) {
        return new IOValidation<>(predicate, onErrorMessage);
    }

    private IOValidation(Predicate<K> predicate, String onErrorMessage) {
        this.predicate = predicate;
        this.onErrorMessage = onErrorMessage;
    }

    @Override
    public ValidationResult test(K param) {
        return predicate.test(param) ? ValidationResult.ok() : ValidationResult.fail(onErrorMessage);
    }

}