package com.tms.repository;

import com.tms.model.Book;
import com.tms.model.BookProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from books as b inner join users_books as ub on b.id = ub.book_id where b.is_deleted = false and b.date_of_issue <= (CURRENT_DATE-20) order by b.date_of_issue", nativeQuery = true)
    Page<Book> findOverdueBooks(Pageable pageable);

    @Query(value = "select * from books as b left join users_books as ub on b.id = ub.book_id where b.is_available = true and b.is_deleted = false order by b.title, b.author, b.id", nativeQuery = true)
    Page<Book> findAvailableBooksToAddToUser(Pageable pageable);

    @Query(value = "select * from books as b full join users_books as ub on b.id = ub.book_id where b.is_deleted = false order by b.title, b.author, b.id", nativeQuery = true)
    Page<Book> findAllNotDeletedBooks(Pageable pageable);

    @Query(value = "select b.author, b.title, b.year, count(b.title) from books as b where b.is_available = true and b.is_deleted = false group by b.author, b.title, b.year order by b.author, b.title, b.year", nativeQuery = true)
    Page<BookProjection> findAllAvailableBooksWithCount(Pageable pageable);

    @Query(value = "select b.title, b.year, count(b.title) from books as b where b.is_available = true and b.is_deleted = false and b.author = :author group by b.title, b.year order by b.title", nativeQuery = true)
    Page<BookProjection> findBooksByAuthor(String author, Pageable pageable);

    @Query(value = "select b.author, b.title, b.year, count(b.title) from books as b where b.is_available = true and b.is_deleted = false and upper(b.author) like upper(:forSearch) or b.is_available = true and b.is_deleted = false and upper(b.title) like upper(:forSearch) group by b.author, b.title, b.year", nativeQuery = true)
    Page<BookProjection> findAvailableBooksFromSearch(String forSearch, Pageable pageable);
}
