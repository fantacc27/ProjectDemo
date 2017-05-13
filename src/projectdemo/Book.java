/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdemo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Xiao
 */
@Entity
@Table(name = "book", catalog = "database_project", schema = "")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
    , @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id")
    , @NamedQuery(name = "Book.findByName", query = "SELECT b FROM Book b WHERE b.name = :name")
    , @NamedQuery(name = "Book.findByPrice", query = "SELECT b FROM Book b WHERE b.price = :price")
    , @NamedQuery(name = "Book.findBySale", query = "SELECT b FROM Book b WHERE b.sale = :sale")
    , @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author")
    , @NamedQuery(name = "Book.findByNation", query = "SELECT b FROM Book b WHERE b.nation = :nation")
    , @NamedQuery(name = "Book.findByPublisher", query = "SELECT b FROM Book b WHERE b.publisher = :publisher")
    , @NamedQuery(name = "Book.findByPublishyear", query = "SELECT b FROM Book b WHERE b.publishyear = :publishyear")
    , @NamedQuery(name = "Book.findByEmail", query = "SELECT b FROM Book b WHERE b.email = :email")
    , @NamedQuery(name = "Book.findByCode", query = "SELECT b FROM Book b WHERE b.code = :code")})
public class Book implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Price")
    private double price;
    @Basic(optional = false)
    @Column(name = "Sale")
    private boolean sale;
    @Basic(optional = false)
    @Column(name = "Author")
    private String author;
    @Basic(optional = false)
    @Column(name = "Nation")
    private String nation;
    @Basic(optional = false)
    @Column(name = "Publisher")
    private String publisher;
    @Basic(optional = false)
    @Column(name = "Publishyear")
    private int publishyear;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Code")
    private int code;

    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Book(Integer id, String name, double price, boolean sale, String author, String nation, String publisher, int publishyear, String email, int code) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sale = sale;
        this.author = author;
        this.nation = nation;
        this.publisher = publisher;
        this.publishyear = publishyear;
        this.email = email;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        double oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public boolean getSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        boolean oldSale = this.sale;
        this.sale = sale;
        changeSupport.firePropertyChange("sale", oldSale, sale);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        String oldAuthor = this.author;
        this.author = author;
        changeSupport.firePropertyChange("author", oldAuthor, author);
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        String oldNation = this.nation;
        this.nation = nation;
        changeSupport.firePropertyChange("nation", oldNation, nation);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        String oldPublisher = this.publisher;
        this.publisher = publisher;
        changeSupport.firePropertyChange("publisher", oldPublisher, publisher);
    }

    public int getPublishyear() {
        return publishyear;
    }

    public void setPublishyear(int publishyear) {
        int oldPublishyear = this.publishyear;
        this.publishyear = publishyear;
        changeSupport.firePropertyChange("publishyear", oldPublishyear, publishyear);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        int oldCode = this.code;
        this.code = code;
        changeSupport.firePropertyChange("code", oldCode, code);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projectdemo.Book[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
