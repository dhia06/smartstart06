<?php

namespace LastBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Participation
 *
 * @ORM\Table(name="participation", indexes={@ORM\Index(name="event_id", columns={"event_id"}), @ORM\Index(name="id", columns={"id"})})
 * @ORM\Entity
 */
class Participation
{
    /**
     * @var integer
     *
     * @ORM\Column(name="paticipant_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $paticipantId;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id", referencedColumnName="id")
     * })
     */
    private $id;

    /**
     * @var \Evenement
     *
     * @ORM\ManyToOne(targetEntity="Evenement")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="event_id", referencedColumnName="id")
     * })
     */
    private $event;



    /**
     * Get paticipantId
     *
     * @return integer
     */
    public function getPaticipantId()
    {
        return $this->paticipantId;
    }

    /**
     * Set id
     *
     * @param \LastBundle\Entity\FosUser $id
     *
     * @return Participation
     */
    public function setId(\LastBundle\Entity\FosUser $id = null)
    {
        $this->id = $id;

        return $this;
    }

    /**
     * Get id
     *
     * @return \LastBundle\Entity\FosUser
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set event
     *
     * @param \LastBundle\Entity\Evenement $event
     *
     * @return Participation
     */
    public function setEvent(\LastBundle\Entity\Evenement $event = null)
    {
        $this->event = $event;

        return $this;
    }

    /**
     * Get event
     *
     * @return \LastBundle\Entity\Evenement
     */
    public function getEvent()
    {
        return $this->event;
    }
}
