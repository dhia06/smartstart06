<?php

namespace LastBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * CandidatureAccept
 *
 * @ORM\Table(name="candidature_accept")
 * @ORM\Entity
 */
class CandidatureAccept
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
     * @ORM\Column(name="nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom", type="string", length=255, nullable=false)
     */
    private $prenom;

    /**
     * @var integer
     *
     * @ORM\Column(name="tel", type="integer", nullable=false)
     */
    private $tel;

    /**
     * @var string
     *
     * @ORM\Column(name="diplome", type="string", length=255, nullable=false)
     */
    private $diplome;

    /**
     * @var string
     *
     * @ORM\Column(name="mail", type="string", length=255, nullable=false)
     */
    private $mail;


}

