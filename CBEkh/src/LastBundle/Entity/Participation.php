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
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="\AppBundle\Entity\User")
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
     * @return int
     */
    public function getPaticipantId()
    {
        return $this->paticipantId;
    }

    /**
     * @param int $paticipantId
     */
    public function setPaticipantId($paticipantId)
    {
        $this->paticipantId = $paticipantId;
    }

    /**
     * @return \User
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param \User $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }



    /**
     * @return \Evenement
     */
    public function getEvent()
    {
        return $this->event;
    }

    /**
     * @param \Evenement $event
     */
    public function setEvent($event)
    {
        $this->event = $event;
    }


}