<?php

namespace MainBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Sponsoring
 *
 * @ORM\Table(name="sponsoring")
 * @ORM\Entity
 */
class Sponsoring
{
    /**
     * @var integer
     *
     * @ORM\Column(name="ref", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $ref;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_contrat", type="date", nullable=false)
     */
    private $dateContrat;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=11, nullable=false)
     */
    private $description;


}

