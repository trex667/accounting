package de.schreibvehler.accounting.entities;


public enum EvidenceType {
    LVChr("Lebensversicherung Christian"),
    RLVChr("Riskolebensversicherung Christian");
    
    private final String description;
    
    private EvidenceType(String desc) {
        description = desc;
    }
    
    public String getDescription() {
        return description;
    }
}
