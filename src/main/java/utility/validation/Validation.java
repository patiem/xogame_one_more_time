package utility.validation;

@FunctionalInterface
interface Validation<K> {

    ValidationResult test(K param);
}

