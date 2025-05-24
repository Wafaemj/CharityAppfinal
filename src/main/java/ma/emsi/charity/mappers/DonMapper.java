package ma.emsi.charity.mappers;


import ma.emsi.charity.dto.DonDTO;
import ma.emsi.charity.entities.Don;

public class DonMapper {

    public static Don dtoToEntity(DonDTO dto) {
        Don don = new Don();
        don.setMontant(dto.getMontant());
        don.setDateDon(dto.getDateDon());
        don.setMethodePaiement(dto.getMethodePaiement());
        // transactionId peut être généré ailleurs
        return don;
    }

    public static DonDTO entityToDto(Don don) {
        DonDTO dto = new DonDTO();
        dto.setMontant(don.getMontant());
        dto.setDateDon(don.getDateDon());
        dto.setMethodePaiement(don.getMethodePaiement());
        return dto;
    }
}