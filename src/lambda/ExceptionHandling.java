package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ExceptionHandling {

	public static void main(String[] args) throws MyException {
		// TODO Auto-generated method stub

		List<Integer> list = new  ArrayList<>();
		list.add(3);
		list.add(7);
		list.add(2);
		list.add(0);
		list.add(1);
		
		//Lambda with exception handling
		
		list.stream().forEach(num -> {
			try {
				System.out.println(num);
			} catch (Exception e) {
				e.printStackTrace();
				//we can throw runtime exception, can not propagate a new checked exception
				//throw new RuntimeException(e.getMessage());
				throw e;
			}
		});
		
		//Lambda wrapper
		list.stream().forEach(Lambda.wrapperInteger(num -> System.out.println("wrapper:"+num)));
		
		//Lambda wrapper Generic
		list.stream().forEach(Lambda.consumerWrapper(num -> System.out.println("Generic:"+num), ArithmeticException.class));
		//==============================================================================================================
		
		list.forEach(ExceptionConsumer.handlingConsumerWrapper(num -> writeToFile(num)));
		
		
	}
	
    static void writeToFile(Integer integer) throws MyException {
        throw new MyException();
    }
}

class MyException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MyException() {
        super();
    }
}

class Lambda {
	
	static Consumer<Integer> wrapperInteger(Consumer<Integer> consumer) {
		return num -> {
			try {
				consumer.accept(num);
			}catch(Exception e) {
				System.out.println("Lambda.wrapperInteger() exception caught!!!");
				throw e;
			}
		};
	}
	
	
	static <T, E extends Exception> Consumer<T>
	  consumerWrapper(Consumer<T> consumer, Class<E> clazz) {
	  
	    return i -> {
	        try {
	            consumer.accept(i);
	        } catch (Exception ex) {
	            try {
	                E exCast = clazz.cast(ex);
	                System.err.println(
	                  "Exception occured : " + exCast.getMessage());
	       
	            } catch (ClassCastException ccEx) {
	                throw ex;
	            }
	        }
	    };
	}
}

@FunctionalInterface
 interface ExceptionConsumer<T, E extends Exception> {
    void accept(T t) throws E;

    static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(ExceptionConsumer<T, E> exceptionConsumer)
        throws E {

        return i -> {
            try {
                exceptionConsumer.accept(i);
            } catch (Exception ex) {
                throwCheckedUnchecked(ex);
            }
        };
    }

    @SuppressWarnings("unchecked")
    static <X extends Throwable> void throwCheckedUnchecked(Throwable t) throws X {
        throw (X) t;
    }
}


