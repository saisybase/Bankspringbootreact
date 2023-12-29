package bankdemo.bankdemosp.repository;

import bankdemo.bankdemosp.DAO.bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bankrepository extends JpaRepository<bank,Long> {
}
