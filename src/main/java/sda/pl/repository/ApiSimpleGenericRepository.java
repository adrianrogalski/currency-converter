package sda.pl.repository;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

public class ApiSimpleGenericRepository<T> extends ApiRepositoryConnect<T> implements SimpleGenericRepository {

    public ApiSimpleGenericRepository(Class<T> modelClass) {
        super(modelClass);
    }
    /*
    returns specified api object from its uri address
     */
    @Override
    public Optional<T> findByURI(URI uri) throws IOException, InterruptedException {
        return get(uri);
    }
}
