package ch.demo.healthappointments.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import ch.demo.healthappointments.dto.SlotCreateRequest;
import ch.demo.healthappointments.exception.BLLException;
import ch.demo.healthappointments.model.Slot;
import ch.demo.healthappointments.repository.SlotRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Service métier de gestion des créneaux.
 * Toutes les données manipulées sont fictives (POC).
 * Aucune donnée patient réelle n'est traitée.
 */
@Service
public class SlotService {

    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    /**
     * Récupère l'ensemble des créneaux, triés dans l'ordre chronologique.
     * @return un {@code Flux<Slot>} émettant les créneaux triés par heure de début,
     *         ou un flux vide si aucun créneau n'est disponible
     */
     public Flux<Slot> getAllSlots() {
        return slotRepository.findAllByOrderByStartTimeAsc();
    }


    /**
     * Crée un nouveau créneau.
     *
     * <p>
     * Le traitement suit les étapes suivantes :
     * <ul>
     *   <li>Validation des heures de début et de fin.</li>
     *   <li>Émission d'une erreur métier si l'heure de fin est avant l'heure de début.</li>
     *   <li>Création de l'entité {@link Slot}.</li>
     *   <li>Sauvegarde du créneau en base de données.</li>
     * </ul>
     * </p>
     *
     * @param request les informations nécessaires à la création du créneau
     * @return un {@code Mono<Slot>} émettant le créneau créé en cas de succès,
     *         ou une erreur métier si les données sont invalides
     * @throws BLLException si l'heure de fin est avant l'heure de début
     */
    public Mono<Slot> createSlot(SlotCreateRequest request) {
        if (request.getEndTime().isBefore(request.getStartTime())) {
            return Mono.error(new BLLException("L'heure de fin doit être après l'heure de début"));
        }

        Slot slot = new Slot(
            null,
            request.getStartTime(),
            request.getEndTime(),
            false
        );
    
        return slotRepository.save(slot);
    }

    /**
     * Réserve un créneau de manière réactive.
     *
     * <p>
     * Le traitement suit les étapes suivantes :
     * <ul>
     *   <li>Recherche du créneau par son identifiant.</li>
     *   <li>Émission d'une erreur si le créneau est introuvable.</li>
     *   <li>Émission d'une erreur si le créneau est déjà réservé.</li>
     *   <li>Marquage du créneau comme réservé et sauvegarde.</li>
     * </ul>
     * </p>
     *
     * @param slotId L'identifiant unique du créneau à réserver.
     * @return Le créneau réservé si la réserve a réussi, une erreur otherwise.
     * @throws BLLException Si le créneau n'existe pas ou si il est déjà réservé.
     */
    public Mono<Slot> reserveSlot(UUID slotId) {
        return slotRepository.findById(slotId)
            .switchIfEmpty(Mono.error(new BLLException("Créneau introuvable")))
            .flatMap(slot -> {
                if (slot.isReserved()) {
                    return Mono.error(new BLLException("Créneau déjà réservé"));
                }

                slot.setReserved(true);
                return slotRepository.save(slot);
            });
    }

}
