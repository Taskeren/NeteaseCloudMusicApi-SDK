package util;

import java.util.function.Consumer;

public class TestUtils {

	public static <T> T apply(T t, Consumer<T> block) {
		block.accept(t);
		return t;
	}

}
