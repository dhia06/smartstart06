<?php

namespace MainBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Offre
 *
 * @ORM\Table(name="offre")
 * @ORM\Entity
 */
class Offre
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="contrat", type="string", length=50, nullable=false)
     */
    private $contrat;

    /**
     * @var string
     *
     * @ORM\Column(name="lieu", type="string", length=20, nullable=false)
     */
    private $lieu;

    /**
     * @var string
     *
     * @ORM\Column(name="remuneration", type="string", length=20, nullable=false)
     */
    private $remuneration;

    /**
     * @var string
     *
     * @ORM\Column(name="competence", type="string", length=50, nullable=false)
     */
    private $competence;

    /**
     * @var string
     *
     * @ORM\Column(name="parttime", type="string", length=50, nullable=false)
     */
    private $parttime;


}

