package workset.beans.entities;

import workset.beans.interfaces.InterfaceBodyType;
import workset.beans.interfaces.InterfaceManufacturer;
import workset.beans.interfaces.InterfaceOS;
import workset.beans.interfaces.InterfacePhone;
import workset.beans.interfaces.InterfacePhoto;
import workset.beans.interfaces.InterfacePrice;
import workset.beans.interfaces.InterfaceProcessor;
import workset.beans.interfaces.InterfaceSIMCardFormat;
import workset.beans.interfaces.InterfaceScratchProtect;
import workset.beans.interfaces.InterfaceScreenResolution;
import workset.beans.interfaces.InterfaceScreenTechnology;

import java.util.ArrayList;
import java.util.HashSet;

import workset.beans.interfaces.InterfaceBatteryType;
import workset.beans.interfaces.InterfaceBodyColor;

public class Phone implements InterfacePhone {
	private int id;
	private String name;
	private String modelYear;
	private InterfaceOS Os;  //operation system
	private double screenSize;
	private InterfaceScreenResolution screenResolution;
	private InterfaceScreenTechnology screenTechnology;
	private double operationMemory;
	private double flashMemory;
	private boolean memoryCard;
	private double camera;  //megapixels
	private double dualSIM;
	private int bataryCapacity;
	private InterfaceBodyType bodyType;
	private boolean lte;
	private HashSet<InterfaceBodyColor> bodyColor;
	private InterfaceScratchProtect scratchprotect;
	private InterfaceProcessor processor;
	private double processorFrequency;
	private byte coresNumber;
	private double frontCamera; //megapixels
	private boolean builtinFlash;
	private boolean autoFocus;
	private boolean opticalStabilization;
	private boolean shockResistanceEsnclosure;
	private boolean dustProtection;
	private boolean qwertyKeyboard;
	private boolean fingerPrint;
	private boolean sosKey;
	private boolean accelerometer;
	private boolean gyroscope;
	private boolean lightSensor;
	private boolean fmRadio;
	private boolean fmTransmitter;
	private boolean gps;
	private boolean glonass;
	private boolean hspa;
	private boolean nfc;
	private boolean bluetooth;
	private boolean wifi;
	private boolean usb;
	private boolean audioOutput;
	private boolean wirelessCharger;
	private boolean Infrared;
	private double timeSpeak;
	private double timewait;
	private boolean stilus;
	private double length; 
	private double width; 
	private double thickness; 
	private double weight; 
	private double judgement; 
	private String description; 
	private String specification; 
	private InterfaceManufacturer manufacturer; 
	private InterfaceBatteryType batteryType; 
	private InterfaceSIMCardFormat simCardFormat; 
	private boolean nonRemovableBattery; 

	private HashSet<InterfacePhoto> photos;
	private HashSet<InterfacePrice> prices;
	
	private double discount;
	private int inStock;
	
	public Phone() {
		super();
	}

	public Phone(int id, String name, String modelYear, InterfaceOS os, double screenSize,
			InterfaceScreenResolution screenResolution, InterfaceScreenTechnology screenTechnology,
			double operationMemory, double flashMemory, boolean memoryCard, double camera, double dualSIM,
			int bataryCapacity, InterfaceBodyType bodyType, boolean lte, HashSet<InterfaceBodyColor> bodyColor,
			InterfaceScratchProtect scratchprotect, InterfaceProcessor processor, double processorFrequency,
			byte coresNumber, double frontCamera, boolean builtinFlash, boolean autoFocus, boolean opticalStabilization,
			boolean shockResistanceEsnclosure, boolean dustProtection, boolean qwertyKeyboard, boolean fingerPrint,
			boolean sosKey, boolean accelerometer, boolean gyroscope, boolean lightSensor, boolean fmRadio,
			boolean fmTransmitter, boolean gps, boolean glonass, boolean hspa, boolean nfc, boolean bluetooth,
			boolean wifi, boolean usb, boolean audioOutput, boolean wirelessCharger, boolean infrared, double timeSpeak,
			double timewait, boolean stilus, double length, double width, double thickness, double weight,
			double judgement, String description, String specification, InterfaceManufacturer manufacturer,
			InterfaceBatteryType batteryType, InterfaceSIMCardFormat simCardFormat, boolean nonRemovableBattery,
			HashSet<InterfacePhoto> photos, HashSet<InterfacePrice> prices, double discount, int inStock) {
		super();
		this.id = id;
		this.name = name;
		this.modelYear = modelYear;
		Os = os;
		this.screenSize = screenSize;
		this.screenResolution = screenResolution;
		this.screenTechnology = screenTechnology;
		this.operationMemory = operationMemory;
		this.flashMemory = flashMemory;
		this.memoryCard = memoryCard;
		this.camera = camera;
		this.dualSIM = dualSIM;
		this.bataryCapacity = bataryCapacity;
		this.bodyType = bodyType;
		this.lte = lte;
		this.bodyColor = bodyColor;
		this.scratchprotect = scratchprotect;
		this.processor = processor;
		this.processorFrequency = processorFrequency;
		this.coresNumber = coresNumber;
		this.frontCamera = frontCamera;
		this.builtinFlash = builtinFlash;
		this.autoFocus = autoFocus;
		this.opticalStabilization = opticalStabilization;
		this.shockResistanceEsnclosure = shockResistanceEsnclosure;
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
		Infrared = infrared;
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
		this.manufacturer = manufacturer;
		this.batteryType = batteryType;
		this.simCardFormat = simCardFormat;
		this.nonRemovableBattery = nonRemovableBattery;
		this.photos = photos;
		this.prices = prices;
		this.inStock = inStock;
		this.discount = discount;
	}
	
	public Phone(int id, String name, String modelYear, InterfaceOS os, double screenSize,
			InterfaceScreenResolution screenResolution, InterfaceScreenTechnology screenTechnology,
			double operationMemory, double flashMemory, boolean memoryCard, double camera, double dualSIM,
			int bataryCapacity, InterfaceBodyType bodyType, boolean lte, HashSet<InterfaceBodyColor> bodyColor,
			InterfaceScratchProtect scratchprotect, InterfaceProcessor processor, double processorFrequency,
			byte coresNumber, double frontCamera, boolean builtinFlash, boolean autoFocus, boolean opticalStabilization,
			boolean shockResistanceEsnclosure, boolean dustProtection, boolean qwertyKeyboard, boolean fingerPrint,
			boolean sosKey, boolean accelerometer, boolean gyroscope, boolean lightSensor, boolean fmRadio,
			boolean fmTransmitter, boolean gps, boolean glonass, boolean hspa, boolean nfc, boolean bluetooth,
			boolean wifi, boolean usb, boolean audioOutput, boolean wirelessCharger, boolean infrared, double timeSpeak,
			double timewait, boolean stilus, double length, double width, double thickness, double weight,
			double judgement, String description, String specification, InterfaceManufacturer manufacturer,
			InterfaceBatteryType batteryType, InterfaceSIMCardFormat simCardFormat, boolean nonRemovableBattery,
			HashSet<InterfacePhoto> photos, HashSet<InterfacePrice> prices) {
		super();
		this.id = id;
		this.name = name;
		this.modelYear = modelYear;
		Os = os;
		this.screenSize = screenSize;
		this.screenResolution = screenResolution;
		this.screenTechnology = screenTechnology;
		this.operationMemory = operationMemory;
		this.flashMemory = flashMemory;
		this.memoryCard = memoryCard;
		this.camera = camera;
		this.dualSIM = dualSIM;
		this.bataryCapacity = bataryCapacity;
		this.bodyType = bodyType;
		this.lte = lte;
		this.bodyColor = bodyColor;
		this.scratchprotect = scratchprotect;
		this.processor = processor;
		this.processorFrequency = processorFrequency;
		this.coresNumber = coresNumber;
		this.frontCamera = frontCamera;
		this.builtinFlash = builtinFlash;
		this.autoFocus = autoFocus;
		this.opticalStabilization = opticalStabilization;
		this.shockResistanceEsnclosure = shockResistanceEsnclosure;
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
		Infrared = infrared;
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
		this.manufacturer = manufacturer;
		this.batteryType = batteryType;
		this.simCardFormat = simCardFormat;
		this.nonRemovableBattery = nonRemovableBattery;
		this.photos = photos;
		this.prices = prices;
		this.inStock = 0;
		this.discount = 0;
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
		return Os;
	}

	public void setOs(InterfaceOS os) {
		Os = os;
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
		this.screenResolution = screenResolution;
	}

	public InterfaceScreenTechnology getScreenTechnology() {
		return screenTechnology;
	}

	public void setScreenTechnology(InterfaceScreenTechnology screenTechnology) {
		this.screenTechnology = screenTechnology;
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
		this.bodyType = bodyType;
	}

	public boolean isLte() {
		return lte;
	}

	public void setLte(boolean lte) {
		this.lte = lte;
	}

	public HashSet<InterfaceBodyColor> getBodyColor() {
		return bodyColor;
	}

	public void setBodyColor(HashSet<InterfaceBodyColor> bodyColor) {
		this.bodyColor = bodyColor;
	}

	public InterfaceScratchProtect getScratchprotect() {
		return scratchprotect;
	}

	public void setScratchprotect(InterfaceScratchProtect scratchprotect) {
		this.scratchprotect = scratchprotect;
	}

	public InterfaceProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(InterfaceProcessor processor) {
		this.processor = processor;
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
		return shockResistanceEsnclosure;
	}

	public void setShockResistanceEsnclosure(boolean shockResistanceEsnclosure) {
		this.shockResistanceEsnclosure = shockResistanceEsnclosure;
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
		return Infrared;
	}

	public void setInfrared(boolean infrared) {
		Infrared = infrared;
	}

	public double getTimeSpeak() {
		return timeSpeak;
	}

	public void setTimeSpeak(double timeSpeak) {
		this.timeSpeak = timeSpeak;
	}

	public double getTimewait() {
		return timewait;
	}

	public void setTimewait(double timewait) {
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
		this.manufacturer = manufacturer;
	}

	public InterfaceBatteryType getBatteryType() {
		return batteryType;
	}

	public void setBatteryType(InterfaceBatteryType batteryType) {
		this.batteryType = batteryType;
	}

	public InterfaceSIMCardFormat getSimCardFormat() {
		return simCardFormat;
	}

	public void setSimCardFormat(InterfaceSIMCardFormat simCardFormat) {
		this.simCardFormat = simCardFormat;
	}

	public boolean isNonRemovableBattery() {
		return nonRemovableBattery;
	}

	public void setNonRemovableBattery(boolean nonRemovableBattery) {
		this.nonRemovableBattery = nonRemovableBattery;
	}

	public HashSet<InterfacePhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(HashSet<InterfacePhoto> photos) {
		this.photos = photos;
	}
	
	public void setPhoto(InterfacePhoto photo) {
		this.photos.add(photo);
	}		

	public HashSet<InterfacePrice> getPrices() {
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

	public void setPrices(HashSet<InterfacePrice> prices) {
		this.prices = prices;
	}
	public void setPrice(InterfacePrice price) {
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
	
}
