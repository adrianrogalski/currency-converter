package sda.pl.repository;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

public interface SimpleGenericRepository<T> {
    Optional<T> findByURI(URI uri) throws IOException, InterruptedException;
}
