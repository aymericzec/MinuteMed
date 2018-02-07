package fr.devsquad.minutemed.arborescence.repository;

import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.domain.NodeAPHP;
import fr.devsquad.minutemed.arborescence.domain.NodeHospital;
import fr.devsquad.minutemed.arborescence.domain.NodePole;
import fr.devsquad.minutemed.arborescence.domain.NodeService;
import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import fr.devsquad.minutemed.arborescence.domain.NodeCU;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ArborescenceRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    /**
     * Get all hospitals of the APHP
     *
     * @return A List of NodeHospital
     */
    public List<NodeHospital> listNodeHospital() {
        return em.createNamedQuery(NodeHospital.FIND_ALL_NODEHOSPITAL, NodeHospital.class).getResultList();
    }

    /**
     * Get all poles of an hospital
     *
     * @param idHospital The id of the hospital
     * @return A List of NodePole
     */
    public List<NodePole> listNodePole(Long idHospital) {
        TypedQuery<NodePole> poles = em.createQuery("SELECT pole FROM NodePole pole WHERE pole.hospital = :idHospital", NodePole.class);
        return poles.setParameter("idHospital", idHospital).getResultList();
    }

    /**
     * Get all services of a pole
     *
     * @param idPole The id of the pole
     * @return A List of NodeService
     */
    public List<NodeService> listNodeService(Long idPole) {
        TypedQuery<NodeService> services = em.createQuery("SELECT service FROM NodeService service WHERE service.pole = :idPole", NodeService.class);
        return services.setParameter("idPole", idPole).getResultList();
    }

    /**
     * Get all hospital units of a service
     *
     * @param idService The id of the service
     * @return A List of NodeHU
     */
    public List<NodeHU> listNodeHU(Long idService) {
        TypedQuery<NodeHU> hu = em.createQuery("SELECT hu FROM NodeHU hu WHERE hu.service = :idService", NodeHU.class);
        return hu.setParameter("idService", idService).getResultList();
    }

    /**
     * Get all care units of a hospital unit
     *
     * @param idHU The id of the hospital unit
     * @return A List of NodeCU
     */
    public List<NodeCU> listNodeCU(Long idHU) {
        TypedQuery<NodeCU> cu = em.createQuery("SELECT cu FROM NodeCU cu WHERE cu.hu = :idHU", NodeCU.class);
        return cu.setParameter("idHU", idHU).getResultList();
    }

    /**
     * Get the node in the Entity Node
     *
     * @param type Type of the Node
     * @param id Id of the Node
     * @return A Node
     */
    public Node findNode(String type, Long id) {
        TypedQuery<Node> node = em.createQuery("SELECT n FROM Node n WHERE n.type = :type AND n.idNodeInfo = :id", Node.class);
        return node.setParameter("type", type).setParameter("id", id).getSingleResult();
    }
   
    /**
     * Get an hospital with its id passed in argument
     * 
     * @param id The id of the hospital
     * @return A NodeHospital
     */
    public NodeHospital findNodeHospital(Long id) {
        return em.find(NodeHospital.class, id);
    }

    /**
     * Get a pole with its id passed in argument
     * 
     * @param id The id of the pole
     * @return A NodePole
     */
    public NodePole findNodePole(Long id) {
        return em.find(NodePole.class, id);
    }

    /**
     * Get a service with its id passed in argument
     * 
     * @param id The id of the service
     * @return A NodeService
     */
    public NodeService findNodeService(Long id) {
        return em.find(NodeService.class, id);
    }

    /**
     * Get a hospital unit with its id passed in argument
     * 
     * @param id The id of the hospital unit
     * @return A NodeHU
     */
    public NodeHU findNodeHospitalUnit(Long id) {
        return em.find(NodeHU.class, id);
    }

    /**
     * Get a care unit with its id passed in argument
     * 
     * @param id The id of the care unit
     * @return A NodeCU
     */
    public NodeCU findNodeCareUnit(Long id) {
        return em.find(NodeCU.class, id);
    }

    /**
     * Insert a NodeAPHP in the database
     * 
     * @param aphp NodeAPHP to add
     * @return The id of the NodeAPHP
     */
    public Long saveNodeAPHP(NodeAPHP aphp) {
        Node node = new Node(aphp.getType(), aphp.getId());
        em.persist(aphp);
        em.persist(node);
        return aphp.getId();
    }

    /**
     * Insert a NodeHospital in the database
     * 
     * @param hospital NodeHospital to add
     * @return The id of the NodeHospital
     */
    public Long saveNodeHospital(NodeHospital hospital) {
        Node node = new Node(hospital.getType(), hospital.getId());
        em.persist(hospital);
        em.persist(node);
        return hospital.getId();
    }

    /**
     * Insert a NodePole in the database
     * 
     * @param pole NodePole to add
     * @return The id of the NodePole
     */
    public Long saveNodePole(NodePole pole) {
        Node node = new Node(pole.getType(), pole.getId());
        em.persist(pole);
        em.persist(node);
        return pole.getId();
    }

    /**
     * Insert a NodeService in the database
     * 
     * @param service NodeService to add
     * @return The id of the NodeService
     */
    public Long saveNodeService(NodeService service) {
        Node node = new Node(service.getType(), service.getId());
        em.persist(service);
        em.persist(node);
        return service.getId();
    }

    /**
     * Insert a NodeHU in the database
     * 
     * @param hu NodeHU to add
     * @return The id of the NodeHU
     */
    public Long saveNodeHospitalUnit(NodeHU hu) {
        Node node = new Node(hu.getType(), hu.getId());
        em.persist(hu);
        em.persist(node);
        return hu.getId();
    }

    /**
     * Insert a NodeCU in the database
     * 
     * @param cu NodeCU to add
     * @return The id of the NodeCU
     */
    public Long saveNodeCareUnit(NodeCU cu) {
        Node node = new Node(cu.getType(), cu.getId());
        em.persist(cu);
        em.persist(node);
        return cu.getId();
    }
}
