package model.DAO;

import java.util.List;

public interface InterfaceDAO<T> {
   public abstract void Create(T objeto);
   public abstract List<T> Retrieve();
   public abstract T Retrieve(int id);
   public abstract void Update(T objeto);
   public abstract void Delete(T objeto);
}
