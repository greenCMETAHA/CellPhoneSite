package workset.beans.entities;


import workset.beans.entities.BatteryType;
import workset.beans.entities.BodyColor;
import workset.beans.entities.BodyStuff;
import workset.beans.entities.BodyType;
import workset.beans.entities.Manufacturer;
import workset.beans.entities.Os;
import workset.beans.entities.PhoneType;
import workset.beans.entities.Photo;
import workset.beans.entities.Price;
import workset.beans.entities.Processor;
import workset.beans.entities.ScratchProtect;
import workset.beans.entities.ScreenResolution;
import workset.beans.entities.ScreenTechnology;
import workset.beans.entities.SimCardFormat;
import workset.beans.interfaces.InterfaceBatteryType;
import workset.beans.interfaces.InterfaceBodyType;
import workset.beans.interfaces.InterfaceManufacturer;
import workset.beans.interfaces.InterfaceOS;
import workset.beans.interfaces.InterfacePhone;
import workset.beans.interfaces.InterfacePhoneType;
import workset.beans.interfaces.InterfacePrice;
import workset.beans.interfaces.InterfaceProcessor;
import workset.beans.interfaces.InterfaceSIMCardFormat;
import workset.beans.interfaces.InterfaceScratchProtect;
import workset.beans.interfaces.InterfaceScreenResolution;
import workset.beans.interfaces.InterfaceScreenTechnology;
import workset.dao.interfaces.InterfaceSimpleDAO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "phones")
public class Phone implements InterfacePhone {
	
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name")
	@Size(min=0, max=120)
	private String name;
	
	@Column(name = "modelyear")
	@Size(min=0, max=45)
	private String modelYear;
	
	@Column(name = "screensize")
	private double screenSize;

	@Column(name = "operationmemory")
	private double operationMemory;
	
	@Column(name = "flashmemory")
	private double flashMemory;
	
	@Column(name = "memorycard")
	private boolean memoryCard;
	
	@Column(name = "camera")
	private double camera;  //megapixels
	
	@Column(name = "dualsim")
	private double dualSIM;
	
	@Column(name = "batarycapacity")
	private int bataryCapacity;
	
	@Column(name = "lte")
	private boolean lte;
	
	@Column(name = "processorfrequency")
	private double processorFrequency;
	
	@Column(name = "coresnumber")
	private byte coresNumber;
	
	@Column(name = "frontcamera")
	private double frontCamera; //megapixels
	
	@Column(name = "builtinflash")
	private boolean builtinFlash;
	
	@Column(name = "autofocus")
	private boolean autoFocus;
	
	@Column(name = "opticalstabilization")
	private boolean opticalStabilization;
	
	@Column(name = "shockresistanceenclosure")
	private boolean shockResistanceEnclosure;
	
	@Column(name = "dustprotection")
	private boolean dustProtection;
	
	@Column(name = "qwertykeyboard")
	private boolean qwertyKeyboard;
	
	@Column(name = "fingerprint")
	private boolean fingerPrint;
	
	@Column(name = "soskey")
	private boolean sosKey;
	
	@Column(name = "accelerometer")
	private boolean accelerometer;
	
	@Column(name = "gyroscope")
	private boolean gyroscope;
	
	@Column(name = "lightsensor")
	private boolean lightSensor;
	
	@Column(name = "fmradio")
	private boolean fmRadio;
	
	@Column(name = "fmtransmitter")
	private boolean fmTransmitter;
	
	@Column(name = "gps")
	private boolean gps;
	
	@Column(name = "glonass")
	private boolean glonass;
	
	@Column(name = "hspa")
	private boolean hspa;
	
	@Column(name = "nfc")
	private boolean nfc;
	
	@Column(name = "bluetooth")
	private boolean bluetooth;
	
	@Column(name = "wifi")
	private boolean wifi;
	
	@Column(name = "usb")
	private boolean usb;
	
	@Column(name = "audiooutput")
	private boolean audioOutput;
	
	@Column(name = "wirelesscharger")
	private boolean wirelessCharger;
	
	@Column(name = "infrared")
	private boolean infrared;
	
	@Column(name = "timespeak")
	@Size(min=0, max=45)
	private String timeSpeak;
	
	@Column(name = "timewait")
	@Size(min=0, max=45)
	private String timewait;
	
	@Column(name = "stilus")
	private boolean stilus;
	
	@Column(name = "length")
	private double length; 
	
	@Column(name = "width")
	private double width; 
	
	@Column(name = "thickness")
	private double thickness; 
	
	@Column(name = "weight")
	private double weight; 
	
	@Column(name = "judgement")
	private double judgement; 
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "specification")
	private String specification;
	
	@Column(name = "nonremovablebattery")
	private boolean nonRemovableBattery;
	
	@Column(name = "discount")
	private double discount;
	
	@Column(name = "instock")
	private int inStock;

	
	@ManyToOne
	private Os os;  //operation system
	
	@ManyToOne
	private ScreenResolution screenResolution;
	
	@ManyToOne
	private ScreenTechnology screenTechnology;
	
	@ManyToOne
	private BodyType bodyType;

	@ManyToOne
	private PhoneType phoneType;
	
	@ManyToOne
	private ScratchProtect scratchprotect;
	
	@ManyToOne
	private Processor processor;
	
	@ManyToOne
	private Manufacturer manufacturer; 
	
	@ManyToOne
	private BatteryType batteryType; 
	
	@ManyToOne
	private SimCardFormat simCardFormat; 
	
	@OneToMany
	@JoinTable(name = "photostable")
	private Set<Photo> photo;
	
	@OneToMany
	@JoinTable(name = "pricestable")
	private Set<Price> prices;
	
	@OneToMany
	@JoinTable(name = "bodycolortable")
	private Set<BodyColor> bodyColor;

	@OneToMany
	@JoinTable(name = "bodystufftable")
	private Set<BodyStuff> bodyStuff;
	

	public Phone() {
		super();
		name="";
	}

	public Phone(int id, String name, String modelYear, InterfaceOS os, double screenSize,
			InterfaceScreenResolution screenResolution, InterfaceScreenTechnology screenTechnology,
			double operationMemory, double flashMemory, boolean memoryCard, double camera, double dualSIM,
			int bataryCapacity, InterfaceBodyType bodyType, boolean lte, HashSet<BodyColor> bodyColor,
			InterfaceScratchProtect scratchprotect, InterfaceProcessor processor, double processorFrequency,
			byte coresNumber, double frontCamera, boolean builtinFlash, boolean autoFocus, boolean opticalStabilization,
			boolean shockResistanceEsnclosure, boolean dustProtection, boolean qwertyKeyboard, boolean fingerPrint,
			boolean sosKey, boolean accelerometer, boolean gyroscope, boolean lightSensor, boolean fmRadio,
			boolean fmTransmitter, boolean gps, boolean glonass, boolean hspa, boolean nfc, boolean bluetooth,
			boolean wifi, boolean usb, boolean audioOutput, boolean wirelessCharger, boolean infrared, String timeSpeak,
			String timewait, boolean stilus, double length, double width, double thickness, double weight,
			double judgement, String description, String specification, InterfaceManufacturer manufacturer, InterfacePhoneType phoneType,
			InterfaceSimpleDAO batteryType, InterfaceSIMCardFormat simCardFormat, boolean nonRemovableBattery,
			HashSet<Photo> photo, HashSet<Price> prices, HashSet<BodyStuff> bodyStuff, double discount, int inStock, boolean shockResistanceEnclosure) {
		super();
		this.id = id;
		this.name = name;
		this.modelYear = modelYear;
		this.os = (workset.beans.entities.Os) os;
		this.screenSize = screenSize;
		this.screenResolution = (ScreenResolution) screenResolution;
		this.screenTechnology = (ScreenTechnology) screenTechnology;
		this.operationMemory = operationMemory;
		this.flashMemory = flashMemory;
		this.memoryCard = memoryCard;
		this.camera = camera;
		this.dualSIM = dualSIM;
		this.bataryCapacity = bataryCapacity;
		this.bodyType = (BodyType) bodyType;
		this.lte = lte;
		this.bodyColor = bodyColor;
		this.scratchprotect = (ScratchProtect) scratchprotect;
		this.processor = (Processor) processor;
		this.processorFrequency = processorFrequency;
		this.coresNumber = coresNumber;
		this.frontCamera = frontCamera;
		this.builtinFlash = builtinFlash;
		this.autoFocus = autoFocus;
		this.opticalStabilization = opticalStabilization;
		this.shockResistanceEnclosure = shockResistanceEnclosure;
		this.dustProtection = dustProtection;
		this.qwertyKeyboard = qwertyKeyboard;
		this.fingerPrint = fingerPrint;
		this.sosKey = sosKey;
		this.accelerometer = accelerometer;
		this.gyroscope = gyroscope;
		this.lightSensor = lightSensor;
		this.fmRadio = fmRadio;
		this.fmTransmitter = fmTransmitter;
		this.gps = gps;
		this.glonass = glonass;
		this.hspa = hspa;
		this.nfc = nfc;
		this.bluetooth = bluetooth;
		this.wifi = wifi;
		this.usb = usb;
		this.audioOutput = audioOutput;
		this.wirelessCharger = wirelessCharger;
		this.infrared = infrared;
		this.timeSpeak = timeSpeak;
		this.timewait = timewait;
		this.stilus = stilus;
		this.length = length;
		this.width = width;
		this.thickness = thickness;
		this.weight = weight;
		this.judgement = judgement;
		this.description = description;
		this.specification = specification;
		this.manufacturer = (Manufacturer) manufacturer;
		this.batteryType = (BatteryType) batteryType;
		this.simCardFormat = (SimCardFormat) simCardFormat;
		this.nonRemovableBattery = nonRemovableBattery;
		this.photo = photo;
		this.prices = prices;
		this.inStock = inStock;
		this.discount = discount;
		this.phoneType = (PhoneType) phoneType;
		this.bodyStuff = bodyStuff;
	}
	
	public Phone(int id, String name, String modelYear, InterfaceOS os, double screenSize,
			InterfaceScreenResolution screenResolution, InterfaceScreenTechnology screenTechnology,
			double operationMemory, double flashMemory, boolean memoryCard, double camera, double dualSIM,
			int bataryCapacity, InterfaceBodyType bodyType, boolean lte, HashSet<BodyColor> bodyColor,
			InterfaceScratchProtect scratchprotect, InterfaceProcessor processor, double processorFrequency,
			byte coresNumber, double frontCamera, boolean builtinFlash, boolean autoFocus, boolean opticalStabilization,
			boolean shockResistanceEsnclosure, boolean dustProtection, boolean qwertyKeyboard, boolean fingerPrint,
			boolean sosKey, boolean accelerometer, boolean gyroscope, boolean lightSensor, boolean fmRadio,
			boolean fmTransmitter, boolean gps, boolean glonass, boolean hspa, boolean nfc, boolean bluetooth,
			boolean wifi, boolean usb, boolean audioOutput, boolean wirelessCharger, boolean infrared, String timeSpeak,
			String timewait, boolean stilus, double length, double width, double thickness, double weight,
			double judgement, String description, String specification, InterfaceManufacturer manufacturer, InterfacePhoneType phoneType,
			InterfaceSimpleDAO batteryType, InterfaceSIMCardFormat simCardFormat, boolean nonRemovableBattery,
			HashSet<Photo> photo, HashSet<Price> prices, HashSet<BodyStuff> bodyStuff, boolean shockResistanceEnclosure) {
		super();
		this.id = id;
		this.name = name;
		this.modelYear = modelYear;
		this.os = (Os) os;
		this.screenSize = screenSize;
		this.screenResolution = (ScreenResolution) screenResolution;
		this.screenTechnology = (ScreenTechnology) screenTechnology;
		this.operationMemory = operationMemory;
		this.flashMemory = flashMemory;
		this.memoryCard = memoryCard;
		this.camera = camera;
		this.dualSIM = dualSIM;
		this.bataryCapacity = bataryCapacity;
		this.bodyType = (BodyType) bodyType;
		this.lte = lte;
		this.bodyColor = bodyColor;
		this.scratchprotect = (ScratchProtect) scratchprotect;
		this.processor = (Processor) processor;
		this.processorFrequency = processorFrequency;
		this.coresNumber = coresNumber;
		this.frontCamera = frontCamera;
		this.builtinFlash = builtinFlash;
		this.autoFocus = autoFocus;
		this.opticalStabilization = opticalStabilization;
		this.shockResistanceEnclosure = shockResistanceEnclosure;
		this.dustProtection = dustProtection;
		this.qwertyKeyboard = qwertyKeyboard;
		this.fingerPrint = fingerPrint;
		this.sosKey = sosKey;
		this.accelerometer = accelerometer;
		this.gyroscope = gyroscope;
		this.lightSensor = lightSensor;
		this.fmRadio = fmRadio;
		this.fmTransmitter = fmTransmitter;
		this.gps = gps;
		this.glonass = glonass;
		this.hspa = hspa;
		this.nfc = nfc;
		this.bluetooth = bluetooth;
		this.wifi = wifi;
		this.usb = usb;
		this.audioOutput = audioOutput;
		this.wirelessCharger = wirelessCharger;
		this.infrared = infrared;
		this.timeSpeak = timeSpeak;
		this.timewait = timewait;
		this.stilus = stilus;
		this.length = length;
		this.width = width;
		this.thickness = thickness;
		this.weight = weight;
		this.judgement = judgement;
		this.description = description;
		this.specification = specification;
		this.manufacturer = (Manufacturer) manufacturer;
		this.batteryType = (BatteryType) batteryType;
		this.phoneType = (PhoneType) phoneType;
		this.simCardFormat = (SimCardFormat) simCardFormat;
		this.nonRemovableBattery = nonRemovableBattery;
		this.photo = photo;
		this.prices = prices;
		this.inStock = 0;
		this.discount = 0;
		this.bodyStuff = bodyStuff;
	}	

	public Phone(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public InterfaceOS getOs() {
		return os;
	}

	public void setOs(InterfaceOS os) {
		this.os = (Os) os;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public InterfaceScreenResolution getScreenResolution() {
		return screenResolution;
	}

	public void setScreenResolution(InterfaceScreenResolution screenResolution) {
		this.screenResolution = (ScreenResolution) screenResolution;
	}

	public InterfaceScreenTechnology getScreenTechnology() {
		return screenTechnology;
	}

	public void setScreenTechnology(InterfaceScreenTechnology screenTechnology) {
		this.screenTechnology = (ScreenTechnology) screenTechnology;
	}

	public double getOperationMemory() {
		return operationMemory;
	}

	public void setOperationMemory(double operationMemory) {
		this.operationMemory = operationMemory;
	}

	public double getFlashMemory() {
		return flashMemory;
	}

	public void setFlashMemory(double flashMemory) {
		this.flashMemory = flashMemory;
	}

	public boolean isMemoryCard() {
		return memoryCard;
	}

	public void setMemoryCard(boolean memoryCard) {
		this.memoryCard = memoryCard;
	}

	public double getCamera() {
		return camera;
	}

	public void setCamera(double camera) {
		this.camera = camera;
	}

	public double getDualSIM() {
		return dualSIM;
	}

	public void setDualSIM(double dualSIM) {
		this.dualSIM = dualSIM;
	}

	public int getBataryCapacity() {
		return bataryCapacity;
	}

	public void setBataryCapacity(int bataryCapacity) {
		this.bataryCapacity = bataryCapacity;
	}

	public InterfaceBodyType getBodyType() {
		return bodyType;
	}

	public void setBodyType(InterfaceBodyType bodyType) {
		this.bodyType = (BodyType) bodyType;
	}

	public boolean isLte() {
		return lte;
	}

	public void setLte(boolean lte) {
		this.lte = lte;
	}

	public Set<BodyColor> getBodyColor() {
		return bodyColor;
	}

	public void setBodyColor(HashSet<BodyColor> bodyColor) {
		this.bodyColor = bodyColor;
	}
	
	public void setBodyColor(BodyColor bodyColor) {
		this.bodyColor.add(bodyColor);
	}

	public InterfaceScratchProtect getScratchprotect() {
		return scratchprotect;
	}

	public void setScratchprotect(InterfaceScratchProtect scratchprotect) {
		this.scratchprotect = (ScratchProtect) scratchprotect;
	}

	public InterfaceProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(InterfaceProcessor processor) {
		this.processor = (Processor) processor;
	}

	public double getProcessorFrequency() {
		return processorFrequency;
	}

	public void setProcessorFrequency(double processorFrequency) {
		this.processorFrequency = processorFrequency;
	}

	public byte getCoresNumber() {
		return coresNumber;
	}

	public void setCoresNumber(byte coresNumber) {
		this.coresNumber = coresNumber;
	}

	public double getFrontCamera() {
		return frontCamera;
	}

	public void setFrontCamera(double frontCamera) {
		this.frontCamera = frontCamera;
	}

	public boolean isBuiltinFlash() {
		return builtinFlash;
	}

	public void setBuiltinFlash(boolean builtinFlash) {
		this.builtinFlash = builtinFlash;
	}

	public boolean isAutoFocus() {
		return autoFocus;
	}

	public void setAutoFocus(boolean autoFocus) {
		this.autoFocus = autoFocus;
	}

	public boolean isOpticalStabilization() {
		return opticalStabilization;
	}

	public void setOpticalStabilization(boolean opticalStabilization) {
		this.opticalStabilization = opticalStabilization;
	}

	public boolean isShockResistanceEsnclosure() {
		return shockResistanceEnclosure;
	}

	public void setShockResistanceEsnclosure(boolean shockResistanceEnclosure) {
		this.shockResistanceEnclosure = shockResistanceEnclosure;
	}

	public boolean isDustProtection() {
		return dustProtection;
	}

	public void setDustProtection(boolean dustProtection) {
		this.dustProtection = dustProtection;
	}

	public boolean isQwertyKeyboard() {
		return qwertyKeyboard;
	}

	public void setQwertyKeyboard(boolean qwertyKeyboard) {
		this.qwertyKeyboard = qwertyKeyboard;
	}

	public boolean isFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(boolean fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public boolean isSosKey() {
		return sosKey;
	}

	public void setSosKey(boolean sosKey) {
		this.sosKey = sosKey;
	}

	public boolean isAccelerometer() {
		return accelerometer;
	}

	public void setAccelerometer(boolean accelerometer) {
		this.accelerometer = accelerometer;
	}

	public boolean isGyroscope() {
		return gyroscope;
	}

	public void setGyroscope(boolean gyroscope) {
		this.gyroscope = gyroscope;
	}

	public boolean isLightSensor() {
		return lightSensor;
	}

	public void setLightSensor(boolean lightSensor) {
		this.lightSensor = lightSensor;
	}

	public boolean isFmRadio() {
		return fmRadio;
	}

	public void setFmRadio(boolean fmRadio) {
		this.fmRadio = fmRadio;
	}

	public boolean isFmTransmitter() {
		return fmTransmitter;
	}

	public void setFmTransmitter(boolean fmTransmitter) {
		this.fmTransmitter = fmTransmitter;
	}

	public boolean isGps() {
		return gps;
	}

	public void setGps(boolean gps) {
		this.gps = gps;
	}

	public boolean isGlonass() {
		return glonass;
	}

	public void setGlonass(boolean glonass) {
		this.glonass = glonass;
	}

	public boolean isHspa() {
		return hspa;
	}

	public void setHspa(boolean hspa) {
		this.hspa = hspa;
	}

	public boolean isNfc() {
		return nfc;
	}

	public void setNfc(boolean nfc) {
		this.nfc = nfc;
	}

	public boolean isBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isUsb() {
		return usb;
	}

	public void setUsb(boolean usb) {
		this.usb = usb;
	}

	public boolean isAudioOutput() {
		return audioOutput;
	}

	public void setAudioOutput(boolean audioOutput) {
		this.audioOutput = audioOutput;
	}

	public boolean isWirelessCharger() {
		return wirelessCharger;
	}

	public void setWirelessCharger(boolean wirelessCharger) {
		this.wirelessCharger = wirelessCharger;
	}

	public boolean isInfrared() {
		return infrared;
	}

	public void setInfrared(boolean infrared) {
		this.infrared = infrared;
	}

	public String getTimeSpeak() {
		return timeSpeak;
	}

	public void setTimeSpeak(String timeSpeak) {
		this.timeSpeak = timeSpeak;
	}

	public String getTimewait() {
		return timewait;
	}

	public void setTimewait(String timewait) {
		this.timewait = timewait;
	}

	public boolean isStilus() {
		return stilus;
	}

	public void setStilus(boolean stilus) {
		this.stilus = stilus;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getThickness() {
		return thickness;
	}

	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getJudgement() {
		return judgement;
	}

	public void setJudgement(double judgement) {
		this.judgement = judgement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public InterfaceManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(InterfaceManufacturer manufacturer) {
		this.manufacturer = (Manufacturer) manufacturer;
	}

	public InterfaceBatteryType getBatteryType() {
		return (InterfaceBatteryType) batteryType;
	}

	public void setBatteryType(BatteryType batteryType) {
		this.batteryType = (BatteryType) batteryType;
	}

	public InterfaceSIMCardFormat getSimCardFormat() {
		return simCardFormat;
	}

	public void setSimCardFormat(InterfaceSIMCardFormat simCardFormat) {
		this.simCardFormat = (SimCardFormat) simCardFormat;
	}

	public boolean isNonRemovableBattery() {
		return nonRemovableBattery;
	}

	public void setNonRemovableBattery(boolean nonRemovableBattery) {
		this.nonRemovableBattery = nonRemovableBattery;
	}

	public Set<Photo> getPhotos() {
		return photo;
	}

	public void setPhotos(HashSet<Photo> photo) {
		this.photo = photo;
	}
	
	public void setPhoto(Photo photo) {
		this.photo.add(photo);
	}		

	public Set<Price> getPrices() {
		return prices;
	}
	
	public InterfacePrice getLastPrice() {
		InterfacePrice result=new Price();
		for (InterfacePrice currentPrice:getPrices()){
			if (result.getTime().getTime()<currentPrice.getTime().getTime()){
				result=currentPrice;
			}
		}
		
		return result;
	}
	
	public double getPriceWithDiscount() {
		InterfacePrice result=new Price();
		for (InterfacePrice currentPrice:getPrices()){
			if (result.getTime().getTime()<currentPrice.getTime().getTime()){
				result=currentPrice;
			}
		}
		double priceWithDiscount=result.getPrice()-getDiscount();
		
		return priceWithDiscount;
	}		

	public void setPrices(HashSet<Price> prices) {
		this.prices = prices;
	}
	public void setPrice(Price price) {
		this.prices.add(price);
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getInStock() {
		return inStock;
	}

	public String getInStockString() {
		return (inStock==0?"В наличии":"Нет на складе");
	}
	
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}	

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public Set<BodyStuff> getBodyStuff() {
		return bodyStuff;
	}

	public void setBodyStuff(HashSet<BodyStuff> bodyStuff) {
		this.bodyStuff = bodyStuff;
	}

	public void addPrice(Price price) {
		this.prices.add(price);
	}
	
	public void addPhoto(Photo photo) {
		this.photo.add(photo);
	}

	public void addBodyColor(BodyColor bodyColor) {
		this.bodyColor.add(bodyColor);
	}	
	
	public void addBodyStuff(BodyStuff bodyStuff) {
		this.bodyStuff.add(bodyStuff);
	}		
}
