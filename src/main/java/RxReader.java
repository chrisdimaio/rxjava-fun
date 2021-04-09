import io.reactivex.*;
import java.io.*;

public class RxReader {
  Observable<String> lines(BufferedReader read) {
    return Observable.create(subscriber -> {
      String line;

      while((line = read.readLine()) != null) {
        subscriber.onNext(line);

        if (subscriber.isDisposed()) {
          break;
        }

        subscriber.onComplete();
      }
    });
  }
}
