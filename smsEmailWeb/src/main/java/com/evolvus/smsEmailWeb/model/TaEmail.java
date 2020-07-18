package com.evolvus.smsEmailWeb.model;




import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.data.jpa.provider.HibernateUtils;



@Entity
@Table(name="ta_email")
public class TaEmail implements Serializable{
	private static final long serialVersionUID = 1L;
    
   /* @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SWS_TA_EMAIL_ID")
   @SequenceGenerator(sequenceName = "SWS_TA_EMAIL_ID", initialValue = 1, allocationSize = 1, name = "SWS_TA_EMAIL_ID")
    int emailId;*/


    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SWS_TA_EMAIL")
	@SequenceGenerator(name = "SWS_TA_EMAIL", sequenceName = "SWS_TA_EMAIL_ID")
	@Column(name = "EMAIL_ID",length=19)
	private int emailId; 

    @Column(name = "TXN_TYPE")
	private String txnType;
	
    @Column(name = "TXN_NUM")
	private String txnRefNum;
	
    @Column(name = "BUSINESS_DATE")
    private Date businessDate;
    
    @Column(name = "FROM_ADDR")
    private String fromAddr;    
    
    @Column(name = "TO_ADDR")
    private String toAddr;
    
    @Lob
    @Column(name = "STATEMENT_TEMPLATE")
    private byte[] reportContentBlob;
    
    @Lob
    @Column(name = "EMAIL_BODY_TEMPLATE")
    private byte[] reportBodyContentBlob;
    
    @Column(name = "STATUS")
    private  char status;
    
    @Column(name = "OBJ_VERSION")
    private int objVersion;
    
    @Column(name = "SUBJECT")
   private String  subject;
   
    @Column(name = "MODIFIED_DATE")
   private String modifiedDate;
   
    @Column(name = "MAIL_DELIVER_ATTEMPT")
   private int deliverAttempt;
    
    
    
    
    
    
    
    
    
    
    
    
    
      

/**
 * @return the emailId
 */



/**
 * @return the txnType
 */
public String getTxnType() {
	return txnType;
}

/**
 * @return the emailId
 */


/**
 * @param txnType the txnType to set
 */
public void setTxnType(String txnType) {
	this.txnType = txnType;
}

/**
 * @return the txnRefNum
 */
public String getTxnRefNum() {
	return txnRefNum;
}

/**
 * @param txnRefNum the txnRefNum to set
 */
public void setTxnRefNum(String txnRefNum) {
	this.txnRefNum = txnRefNum;
}

/**
 * @return the businessDate
 */
public Date getBusinessDate() {
	return businessDate;
}

/**
 * @param businessDate the businessDate to set
 */
public void setBusinessDate(Date businessDate) {
	this.businessDate = businessDate;
}

/**
 * @return the fromAddr
 */
public String getFromAddr() {
	return fromAddr;
}

/**
 * @param fromAddr the fromAddr to set
 */
public void setFromAddr(String fromAddr) {
	this.fromAddr = fromAddr;
}

/**
 * @return the toAddr
 */
public String getToAddr() {
	return toAddr;
}

/**
 * @param toAddr the toAddr to set
 */
public void setToAddr(String toAddr) {
	this.toAddr = toAddr;
}

/**
 * @return the reportContent
 */


/**
 * @return the status
 */
public char getStatus() {
	return status;
}

/**
 * @param status the status to set
 */
public void setStatus(char status) {
	this.status = status;
}

/**
 * @return the objVersion
 */
public int getObjVersion() {
	return objVersion;
}

/**
 * @param objVersion the objVersion to set
 */
public void setObjVersion(int objVersion) {
	this.objVersion = objVersion;
}

/**
 * @return the subject
 */
public String getSubject() {
	return subject;
}

/**
 * @param subject the subject to set
 */
public void setSubject(String subject) {
	this.subject = subject;
}

/**
 * @return the modifiedDate
 */
public String getModifiedDate() {
	return modifiedDate;
}

/**
 * @param modifiedDate the modifiedDate to set
 */
public void setModifiedDate(String modifiedDate) {
	this.modifiedDate = modifiedDate;
}

/**
 * @return the deliverAttempt
 */
public int getDeliverAttempt() {
	return deliverAttempt;
}

/**
 * @param deliverAttempt the deliverAttempt to set
 */
public void setDeliverAttempt(int deliverAttempt) {
	this.deliverAttempt = deliverAttempt;
}

/**
 * @return the serialversionuid
 */
public static long getSerialversionuid() {
	return serialVersionUID;
}

/**
 * @return the emailId
 */
public int getEmailId() {
	return emailId;
}

/**
 * @param emailId the emailId to set
 */
public void setEmailId(int emailId) {
	this.emailId = emailId;
}

public byte[] getReportContentBlob() {
	
	
	 byte[] result = null;
     if (reportContentBlob != null) {
         result = (byte[]) (reportContentBlob).clone();
     }
     return result;

	
	//return reportContentBlob;
}

/*public void setReportContentBlob(Blob reportContentBlob) {
	this.reportContentBlob = reportContentBlob;
}*/
public void setReportContentBlob(final byte[] reportContentBlob) {
    this.reportContentBlob = (byte[]) reportContentBlob.clone();
}



public byte[] getReportBodyContentBlob() {
	 byte[] result = null;
     if (reportBodyContentBlob != null) {
         result = (byte[]) (reportBodyContentBlob).clone();
     }
     return result;

	
	//return reportContentBlob;

	
	
	//return reportBodyContentBlob;
}

public void setReportBodyContentBlob(final byte[] reportBodyContentBlob) {
	this.reportBodyContentBlob = (byte[]) reportBodyContentBlob.clone();
}

/**
 * @return the reportContent
 */
/*public byte[] getReportContent() {
	return reportContent;
}

*//**
 * @param reportContent the reportContent to set
 *//*
public void setReportContent(byte[] reportContent) {
	this.reportContent = reportContent;
}

*//**
 * @return the reportBodyContent
 *//*
public byte[] getReportBodyContent() {
	return reportBodyContent;
}

*//**
 * @param reportBodyContent the reportBodyContent to set
 *//*
public void setReportBodyContent(byte[] reportBodyContent) {
	this.reportBodyContent = reportBodyContent;
}

public Blob getReportBodyContentBlob() {
	 Blob fileBlob = null ;
	   try {
		   fileBlob =  new javax.sql.rowset.serial.SerialBlob(this.reportBodyContent);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return fileBlob;
	 }

public void setReportBodyContentBlob(Blob reportBodyContentBlob) {
	  this.reportBodyContent = this.toByteArray(reportBodyContentBlob);
	 }

public Blob getReportContentBlob() {
	 if(this.reportContent != null)
	 {
		 Blob fileBlob = null ;
		try {
			return new javax.sql.rowset.serial.SerialBlob(this.reportContent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return fileBlob;
	 }
	 else
	 {
		 return null;
	 }
}

public void setReportContentBlob(Blob reportContentBlob) {
	 if(reportContentBlob != null)
	 {
		 this.reportContent = this.toByteArray(reportContentBlob);
	 }
	 else
	 {
		 this.reportContent = null;
	 }
}

private byte[] toByteArray(Blob fromBlob) {
	  ByteArrayOutputStream baos = new ByteArrayOutputStream();
	  try {
	   return toByteArrayImpl(fromBlob, baos);
	  } catch (SQLException e) {
	   throw new RuntimeException(e);
	  } catch (IOException e) {
	   throw new RuntimeException(e);
	  } finally {
	   if (baos != null) {
	    try {
	     baos.close();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
	   }
	  }
	 }

	 private byte[] toByteArrayImpl(Blob fromBlob, ByteArrayOutputStream baos)
	  throws SQLException, IOException {
	  byte[] buf = new byte[4000];
	  InputStream is = fromBlob.getBinaryStream();
	  try {
	   for (;;) {
	    int dataSize = is.read(buf);

	    if (dataSize == -1)
	     break;
	    baos.write(buf, 0, dataSize);
	   }
	  } finally {
	   if (is != null) {
	    try {
	     is.close();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
	   }
	  }
	  return baos.toByteArray();
	 }*/
   
  /*Configuration configuration = new Configuration().configure();
	 SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	 Session session = sessionFactory.openSession();
   

	*//**
	 * @return the emailId
	 *//*
	public int getEmailId() {
		return emailId;
	}

	*//**
	 * @param emailId the emailId to set
	 *//*
	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}

	*//**
	 * @return the txnType
	 *//*
	public String getTxnType() {
		return txnType;
	}

	*//**
	 * @param txnType the txnType to set
	 *//*
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	*//**
	 * @return the txnRefNum
	 *//*
	public String getTxnRefNum() {
		return txnRefNum;
	}

	*//**
	 * @param txnRefNum the txnRefNum to set
	 *//*
	public void setTxnRefNum(String txnRefNum) {
		this.txnRefNum = txnRefNum;
	}

	*//**
	 * @return the businessDate
	 *//*
	public Date getBusinessDate() {
		return businessDate;
	}

	*//**
	 * @param businessDate the businessDate to set
	 *//*
	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}

	*//**
	 * @return the fromAddr
	 *//*
	public String getFromAddr() {
		return fromAddr;
	}

	*//**
	 * @param fromAddr the fromAddr to set
	 *//*
	public void setFromAddr(String fromAddr) {
		this.fromAddr = fromAddr;
	}

	*//**
	 * @return the toAddr
	 *//*
	public String getToAddr() {
		return toAddr;
	}

	*//**
	 * @param toAddr the toAddr to set
	 *//*
	public void setToAddr(String toAddr) {
		this.toAddr = toAddr;
	}


	*//**
	 * @return the status
	 *//*
	public char getStatus() {
		return status;
	}

	*//**
	 * @param status the status to set
	 *//*
	public void setStatus(char status) {
		this.status = status;
	}

	*//**
	 * @return the objVersion
	 *//*
	public int getObjVersion() {
		return objVersion;
	}

	*//**
	 * @param objVersion the objVersion to set
	 *//*
	public void setObjVersion(int objVersion) {
		this.objVersion = objVersion;
	}

	*//**
	 * @return the subject
	 *//*
	public String getSubject() {
		return subject;
	}

	*//**
	 * @param subject the subject to set
	 *//*
	public void setSubject(String subject) {
		this.subject = subject;
	}

	*//**
	 * @return the reportContent
	 *//*
	public byte[] getReportContent() {
		return reportContent;
	}

	*//**
	 * @param reportContent the reportContent to set
	 *//*
	public void setReportContent(byte[] reportContent) {
		this.reportContent = reportContent;
	}

	*//**
	 * @return the reportBodyContent
	 *//*
	public byte[] getReportBodyContent() {
		return reportBodyContent;
	}

	*//**
	 * @param reportBodyContent the reportBodyContent to set
	 *//*
	public void setReportBodyContent(byte[] reportBodyContent) {
		this.reportBodyContent = reportBodyContent;
	}

	 public Blob getReportContentBlob() {
		 if(this.reportContent != null)
		 {
			
		return Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(this.reportContent);
		 }
		 else
		 {
			 return null;
		 }
	}
	 
	 public void setReportContentBlob(Blob reportContentBlob) {
		 if(reportContentBlob != null)
		 {
			 this.reportContent = this.toByteArray(reportContentBlob);
		 }
		 else
		 {
			 this.reportContent = null;
		 }
	 }
	 
	 
	 public Blob getReportBodyContentBlob() {
		 return Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(this.reportBodyContent);
		 }

	 public void setReportBodyContentBlob(Blob reportBodyContentBlob) {
		  this.reportBodyContent = this.toByteArray(reportBodyContentBlob);
		 }
	 
	 
	 
	 
	 

	 private byte[] toByteArray(Blob fromBlob) {
	  ByteArrayOutputStream baos = new ByteArrayOutputStream();
	  try {
	   return toByteArrayImpl(fromBlob, baos);
	  } catch (SQLException e) {
	   throw new RuntimeException(e);
	  } catch (IOException e) {
	   throw new RuntimeException(e);
	  } finally {
	   if (baos != null) {
	    try {
	     baos.close();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
	   }
	  }
	 }

	 private byte[] toByteArrayImpl(Blob fromBlob, ByteArrayOutputStream baos)
	  throws SQLException, IOException {
	  byte[] buf = new byte[4000];
	  InputStream is = fromBlob.getBinaryStream();
	  try {
	   for (;;) {
	    int dataSize = is.read(buf);

	    if (dataSize == -1)
	     break;
	    baos.write(buf, 0, dataSize);
	   }
	  } finally {
	   if (is != null) {
	    try {
	     is.close();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
	   }
	  }
	  return baos.toByteArray();
	 }

	*//**
	 * @return the modifiedDate
	 *//*
	public String getModifiedDate() {
		return modifiedDate;
	}

	*//**
	 * @param modifiedDate the modifiedDate to set
	 *//*
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getDeliverAttempt() {
		return deliverAttempt;
	}

	public void setDeliverAttempt(int deliverAttempt) {
		this.deliverAttempt = deliverAttempt;
	}

 

	 
	


    //@Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    Date date;

    public Customer(String name, String email, Date date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
*/
   
}
