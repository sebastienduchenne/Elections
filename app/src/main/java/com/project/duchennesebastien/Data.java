package com.project.duchennesebastien;

import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 01/05/2015.
 */
public class Data {

    public static int temps = 1;
    public static boolean AVote = false;
    public static String departementChoisi = "";
    public static String cantonChoisi = "";
    public static String election_choisie = "Elections départementales de 2015";
    public static boolean aChoisiListeCandidat = false;
    public static boolean actuAvecLien = false;
    public static boolean aRecuNotification = false;
    public static int acces = 0; // 0 : rien - 1 : liste - 3 : résultats

    public static int[] img = new int[]{
            R.drawable.actu_0_candidatures,
            R.drawable.actu_1_nouvelles_dep,
            R.drawable.actu_2_candidats_t1,
            R.drawable.actu_3_voter,
            R.drawable.actu_4_participation,
            R.drawable.actu_5_resultats_t1
    };

    public static int[] photosPresidentielle = new int[]{
            R.drawable.photo_francois_hollande,
            R.drawable.photo_sarkozy,
            R.drawable.photo_marine_le_pen,
            R.drawable.photo_jean_luc_melenchon,
            R.drawable.photo_francois_bayrou,
            R.drawable.photo_eva_joly,
            R.drawable.photo_nicolas_dupont_aignan,
            R.drawable.photo_philippe_poutou,
            R.drawable.photo_nathalie_arthaud,
            R.drawable.photo_jacques_cheminade,
    };

    public static int[] photosDepartementaleClayeSouilly = new int[]{
            R.drawable.logo_fn,
            R.drawable.logo_ump,
            R.drawable.logo_front_gauche,
            R.drawable.logo_eelv,
    };

    public static int[] photosDepartementaleReims1 = new int[]{
            R.drawable.logo_ump,
            R.drawable.logo_ps,
            R.drawable.logo_fn,
            R.drawable.logo_eelv,
    };

    public static String [][] tab_candidats_presidentielles_tour1 = new String[][]{
            {"François Hollande","Parti Socialiste","28,63 %","10 272 705 voix"},
            {"Nicolas Sarkozy","Union pour un Mouvement Populaire","27,18 %","9 753 629 voix"},
            {"Marine Le Pen","Front National","17,90 %","6 421 426 voix"},
            {"Jean-Luc Mélenchon","Front de Gauche","11,10 %","3 984 822 voix"},
            {"François Bayrou","Mouvement Démocrate","9,13 %","3 275 122 voix"},
            {"Eva Joly","Europe-Ecologie-Les Verts","2,31 %","828 345 voix"},
            {"Nicolas Dupont-Aignan","Debout la France","1,79 %","643 907 voix"},
            {"Philippe Poutou ","Nouveau Parti Anticapitaliste","1,15 %","411 160 voix"},
            {"Nathalie Arthaud","Lutte Ouvrière","0,56 %","202 548 voix"},
            {"Jacques Cheminade","Solidarité et Progrès","0,25 %", "89 545 voix"},
            {"Vote blanc"}
    };

    public static String [] tab_statistiques_presidentielles_tour1 = new String[]{
            "Inscrits : 46 028 542",
            "Abstention : 20,52 % (9 444 143)",
            "Votants : 79,48 % (36 584 399)",
    };

    public static String [] tab_statistiques_presidentielles_tour2 = new String[]{
            "Inscrits : 46 066 307",
            "Abstention : 19,65 % (9 049 998)",
            "Votants : 80,35 % (37 016 309)",
    };

    public static String [][] tab_candidats_départementales_marne_canton_reims_1 = new String[][]{
            {"Stéphane Lang et Stéfana Vuibert","UMP","51,24 %", "3 669 voix","66,92 %","4 442 voix"},
            {"Jacques Cohen et Imane Maniani","SOC","23,20 %","1 661 voix","33,08 %","2 196 voix"},
            {"Jean-Pierre Catté et Séverina Chazerie","FN","16,25 %","1 164 voix","",""},
            {"Claudine Escoute et Raymond Joannesse","VEC","9,31 %","667 voix","",""},
            {"Vote blanc"}
    };

    public static String [][] tab_candidats_départementales_seine_et_marne_canton_claye_souilly = new String[][]{
            {"Béatrice Troussard et Guy Lotte", "FN","38,72 %","5 719 voix","59,04 %","8 303 voix"},
            {"Olivier Morin et Véronique Pasquier","UMP","34,98 %","5 166 voix","40,96 %","5 760 voix"},
            {"Gérard Bardin et Coralie Jobelin","FG","15,97 %","2 358 voix","",""},
            {"Josiane Deknuydt et Renaud Hee","EELV","10,33 %","1 526 voix","",""},
            {"Vote blanc"}
    };


    public static String [] tab_statistiques_départementales_marne_canton_reims_1 = new String[]{
            "Inscrits : 15 066",
            "Abstention : 52,85 % (7 962)",
            "Votants : 47,15 % (7 104)",
    };

    public static String [] tab_statistiques_départementales_seine_et_marne_canton_claye_souilly = new String[]{
            "Inscrits : 32 108",
            "Abstention : 51,85 % (16 648)",
            "Votants : 48,15 % (15 460)",
    };


    public static String[][] tab_calendrier_election = new String[][]{
            {"2012 : élection présidentielle","1er tour : 22 avril", "\n2ème tour : 6 mai", "Election présidentielle de 2012"},
            {"2015 : élections départementales","1er tour : 22 mars", "\n2ème tour : 29 mars", "Elections départementales de 2015"},
            {"2015 : élections régionales","1er tour : 6 décembre", "\n2ème tour : 13 décembre", "Elections régionales de 2015"},
            {"2017 : élection présidentielle","Dates non définies", "", "Election présidentielle de 2017"},
            {"2019 : élections européennes","Dates non définies", "", "Elections européennes de 2019"},
            {"2020 : élections municipales","Dates non définies", "", "Elections municipales de 2020"},
            {"2021 : élections départementales","Dates non définies", "", "Elections départementales de 2021"}
    };


    public static String[][] tab_actualites = new String[][]{
            {"17 février 2015","Candidature aux élections départementales 2015", "Les 22 et 29 mars prochains, les électeurs seront appelés aux urnes pour élire les nouveaux conseillers départementaux.\n" +
                    "\n" +
                    "Les candidats avaient une semaine pour se déclarer, entre le 9 et le 16 février. Cette période de dépôt des candidatures pour le premier tour étant close, la liste des candidats aux élections départementales est désormais disponible.\n" +
                    "Cette liste peut-néanmoins être amenée à évoluer puisque les dernières candidatures déposées sont en cours de vérification par les préfectures. Les préfets de département ont jusqu'au 20 février pour publier l'arrêté fixant la liste des candidats pour le premier tour des élections départementales 2015."},
            {"4 mars 2015","Lancement de la campagne #OuiJeVote", "Les élections départementales ont lieu les 22 et 29 mars 2015.\n" +
                    "\n" +
                    "Les élections départementales remplacent les élections cantonales et désignent les membres du conseil départemental (ex-conseil général) dans le cadre du canton.\n\n" +
                    "Les conseillers généraux élus en 2008 et en 2011 sont tous remplacés en mars 2015 par des conseillers départementaux.\n" +
                    "A compter de ce scrutin, les conseils généraux et les conseillers généraux seront dénommés respectivement conseils départementaux et conseillers départementaux.\n" +
                    "Ces élections ont lieu dans le cadre de la nouvelle carte cantonale dont les limites ont fait l’objet d’une révision générale entre mars 2013 et février 2014.\n\n" +
                    "Les conseillers départementaux seront ainsi élus dans les 2 054 cantons issus de cette réforme.\n" +
                    "Concernant Paris, à la fois commune et département, il n’y a pas d’élections départementales, le Conseil de Paris étant élu selon le scrutin municipal.\n" +
                    "Les mandats des conseillers généraux de Guyane et de Martinique seront prolongés jusqu’à la création de la collectivité territoriale unique qui interviendra au 1er janvier 2016. Ces départements auront alors une assemblée unique avec à la fois les compétences d’un département et d’une région. Les scrutins relatifs aux futures collectivités uniques de Guyane et de Martinique se dérouleront en décembre 2015, à l’instar du scrutin de renouvellement des conseils régionaux.\n\n" +
                    "Dans le département du Rhône, les élections départementales de mars 2015 ne concernent pas le territoire de la métropole de Lyon où les conseillers communautaires, qui sont devenus les conseillers de la métropole de Lyon au 1er janvier 2015, garderont les compétences départementales."},
            {"10 mars 2015","Découvrez les candidats du 1er tour des élections départementales", "Cliquez ici pour les consulter."},
            {"22 mars 2015","Vous êtes appelé à voter pour le 1er tour des élections départementales", "Cliquer ici pour vous connecter."},
            {"22 mars 2015","Taux de participation à 12h00 du 1er tour", "Les élections départementales ont lieu le 22 mars pour le premier tour et le 29 mars pour le second tour.\n\n" +
                    "Elles se déroulent dans le cadre de la nouvelle carte cantonale à l'exception de Paris, de la métropole de Lyon, de la Guyane et de la Martinique.\n\n" +
                    "A 12h00, au premier tour des élections départementales, le taux de participation pour la France métropolitaine s'élevait à 18,02 %.\n\n" +
                    "Au premier tour des élections cantonales de 2008 à la même heure, le taux de participation était de 22,25 %, et en 2011 il était de 15,70 %.\n" +
                    "Les résultats France entière du premier tour seront disponibles à partir de 20h00."},
            {"22 mars 2015","Résultats du 1er tour des élections départementales", "Cliquez ici pour les consulter."}
    };

    public static String[][] tab_parametre = new String[][] {
            {"Pays", "Non défini"},
            {"Région", "Non définie"},
            {"Département","Non défini"},
            {"Canton","Non défini"},
            {"Commune","Non définie"}
    };

    public static String[][] tab_parametres = new String[][] {
            {"Pays", "France"},
            {"Région", "Ile-de-France"},
            {"Département","77 - Seine-et-Marne"},
            {"Canton","Claye-Souilly"},
            {"Commune","Villenoy"}
    };

    public static String[] tab_info_cle1 = new String[] {
            "Le système électoral",
            "L'inscription sur les listes électorales",
            "Le vote des français à l'étranger",
    };

    public static String[] tab_info_cle2 = new String[] {
            "Européennes",
            "Présidentielles",
            "Régionales",
            "Départementales",
            "Municipales",
    };

    public static String[] tab_pays = new String[] {
            "Allemagne",
            "Espagne",
            "France",
            "Grande Bretagne",
            "Suisse",
    };

    public static String[] tab_regions = new String[] {
            "Bretagne",
            "Champagne-Ardenne",
            "Ile-de-France",
            "Normandie",
            "Provence-Alpes-Côte d'Azur",
    };

    public static String [] tab_departements_ile_de_france = new String[]{
            "75 - Paris",
            "77 - Seine-et-Marne",
            "78 - Yvelines",
            "91 - Essonne",
            "92 - Hauts-de-Seine" ,
            "93 - Seine-Saint-Denis",
            "94 - Val-de-Marne",
            "95 - Val-d'Oise"
    };

    public static String [] tab_departements_champagne_ardennes = new String[]{
            "08 - Ardennes",
            "10 - Aube",
            "51 - Marne",
            "52 - Haute-Marne"
    };

    public static String[] tab_cantons_seine_et_marne = new String[] {
            "Claye-Souilly",
            "Meaux",
            "Melun",
            "Provins",
            "Torcy",
            "Villeparisis"
    };

    public static String[] tab_cantons_marne = new String[] {
            "Châlons-en-Champagne - 1",
            "Epernay - 1",
            "Reims - 1",
            "Reims - 2",
            "Vitry-le-François-Champagne et Der"
    };

    public static String[] tab_communes_canton_claye_souilly = new String[] {
            "Claye-Souilly",
            "Crégy-lès-Meaux",
            "Villenoy",
            "Villeroy"
    };


    public static String infoCle1= "<!DOCTYPE html>\n" +
            "<html>\n" +
            "    <head>\n" +
            "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" +
            "    </head>\n" +
            "    <body>\n" +
            "<h1>L'inscription sur les listes électorales</h1>\n" +
            "<p>Les modalités pour s'inscrire sur les listes électorales.</p>\n" +
            "<hr class=\"clearfloat\" />\t    \n" +
            "\n" +
            "<h2>Principe :</h2>\n" +
            "<p>Pour pouvoir voter, il faut être inscrit sur les listes électorales.</p>\n" +
            "<p>L'inscription est automatique pour les jeunes de 18 ans. En dehors de cette situation, l'inscription sur les listes doit faire l'objet d'une démarche volontaire.</p>\n" +
            "\n" +
            "<h2>Qui peut être électeur ?</h2>\n" +
            "<p>Il faut remplir les conditions suivantes :</p>\n" +
            "\n" +
            "<p>\n" +
            "- être âgé d'au moins 18 ans la veille du 1er tour de scrutin ;<br />\n" +
            "- être de nationalité française (les citoyens européens résidant en France peuvent s'inscrire sur les listes complémentaires mais seulement pour participer aux élections municipales et/ou européennes) ;<br />- jouir de ses droits civils et politiques.</p><a name=\"eztoc16689_0_3\" id=\"eztoc16689_0_3\"></a><h2>Où s'inscrire ?</h2><p>\n" +
            "- Soit à la mairie de son domicile ;<br />\n" +
            "- Soit à la mairie d'une commune dans laquelle on est assujetti aux impôts locaux depuis au moins 5 ans ;<br />\n" +
            "- Soit à la mairie de sa résidence à condition d'y résider de manière effective et continue depuis au moins 6 mois ;<br />- Soit à la mairie de la commune où l'on est assujetti à résidence obligatoire en tant que fonctionnaire public.</p><a name=\"eztoc16689_0_4\" id=\"eztoc16689_0_4\"></a><h2>Comment s'inscrire ?</h2><p>\n" +
            "- Soit en se rendant à la mairie avec les pièces exigées,<br />\n" +
            "- Soit par courrier, en envoyant à la mairie le formulaire d'inscription et les pièces exigées,<br />\n" +
            "- Soit par internet, en utilisant le téléservice proposé par mon-service-public.fr (pour 2000 communes aujourd'hui).\n" +
            "\n" +
            "</p><table class=\"miomcti_renderedtable\" border=\"1\" cellpadding=\"2\" cellspacing=\"0\"><tr><th valign=\"top\">  Documents à fournir\n" +
            "  </th><th valign=\"top\">  Précisions et cas particuliers\n" +
            "  </th></tr><tr class=\"bglight\"><td valign=\"top\">  Formulaire d'inscription\n" +
            "  </td><td valign=\"top\">  Disponible en mairie ou en ligne\n" +
            "  </td></tr><tr class=\"bgdark\"><td valign=\"top\">  Pièce d'identité\n" +
            "  </td><td valign=\"top\">  <p>La pièce doit prouver la nationalité française (passeport ou carte nationale d'identité).</p><p>Elle doit être récente : valide ou expirée depuis moins d'1 an.</p><p>Si vous êtes devenu français récemment et que vous ne possédez pas encore de pièce d'identité française : pièce d'identité d'origine + une preuve de la nationalité française (décret de naturalisation, certificat de nationalité)</p>\n" +
            "  </td></tr><tr class=\"bglight\"><td valign=\"top\">  Justificatif de domicile\n" +
            "  </td><td valign=\"top\">  <p>Selon les situations, il convient de fournir l'une de ces pièces :</p><p>- S'il s'agit de votre domicile : un justificatif de domicile de moins de 3 mois</p><p>\n" +
            "- S'il s'agit du domicile de vos parents : attestation du parent (sur papier libre) certifiant que vous habitez chez lui&nbsp; + un justificatif de domicile du parent <br />\n" +
            "&nbsp;<br />\n" +
            "- S'il s'agit de votre résidence : justificatif de la résidence depuis plus de 6 mois dans la commune <br />\n" +
            "&nbsp;<br />- Si vous êtes seulement contribuable : justificatif d'inscription au rôle des impôts locaux depuis plus de 5 ans</p>\n" +
            "  </td></tr>\n" +
            "</table>\n" +
            "\n" +
            "<h2>Quand s'inscrire ?</h2>\n" +
            "<p>Mis à part quelques cas particuliers, pour pouvoir voter, il faut s'inscrire avant la fin de l'année qui précède le scrutin.</p>\n" +
            "<p><b>Principe : avant le 31 décembre</b></p>\n" +
            "<p>Il est possible de s'inscrire à tout moment de l'année mais vous ne pouvez voter qu'à partir du 1er mars de l'année suivante (après la révision annuelle des listes électorales).<br />\n" +
            "Pour pouvoir voter en 2015, il faut donc s'inscrire au plus tard<b>&nbsp;le 31 décembre 2014</b>.</p><p><b>Cas particuliers : inscription l'année de l'élection</b></p>\n" +
            "<p>Si vous êtes dans l'une des situations suivantes, vous pouvez vous inscrire et voter la même année :</p>\n" +
            "<p>\n" +
            "- Jeune ayant atteint l'âge de 18 ans entre le 1er mars et le jour de l'élection,<br />\n" +
            "- Personne qui déménage pour des motifs professionnels et fonctionnaire admis à la retraite après le 1er janvier,<br />\n" +
            "- Militaire retournant à la vie civile après le 1er janvier,<br />\n" +
            "- Acquisition de la nationalité française après le 1er janvier,<br />- Recouvrement de l'exercice du droit de vote après le 1er janvier.</p>\n" +
            "\n" +
            "    </body>\n" +
            "</html>";


    public static String infoCle2= "<!DOCTYPE html>\n" +
            "<html>\n" +
            "    <head>\n" +
            "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" +
            "    </head>\n" +
            "\n" +
            "    <body>\n" +
            "\t\n" +
            "<div class=\"content-view-full\">\n" +
            "\t    <div class=\"class-sub_rubric\">\n" +
            "\t\n" +
            "\t    <div class=\"attribute-header\">\n" +
            "\t        <h1>Le vote des Français à l'étranger</h1>\n" +
            "\t    </div>\n" +
            "\t\t\t    \t\t<div class=\"attribute-catcher\">\n" +
            "\t        \n" +
            "<p>En 2012, vous avez participé aux élections du Président de la République et, pour la première fois, à l'élection d'un des onze députés représentant les Français établis hors de France.</p>\n" +
            "<hr class=\"clearfloat\" />\t    </div>\n" +
            "\t    \t    \t\t<div class=\"attribute-text\">\n" +
            "\t        \n" +
            "<p>Si vous souhaitez voter à l’étranger pour les prochaines échéances électorales, inscrivez-vous auprès de votre consulat\n" +
            " avant le 31 décembre de l'année précédant celle des scrutins.</p><a name=\"eztoc18638_0_0_1\" id=\"eztoc18638_0_0_1\"></a><h3>Informations pour les candidats à une élection</h3><a name=\"eztoc18638_0_0_1_1\" id=\"eztoc18638_0_0_1_1\"></a><h4>Dépôts de candidature</h4>\n" +
            "<div class=\"bloc_background double_spacer\"><p>Les déclarations de candidature sont à déposer auprès du ministère de l'intérieur, à l'adresse suivante :</p><p class=\" text-left\">\n" +
            "Ministère de l'intérieur<br />\n" +
            "Bureau des élections<br />\n" +
            "Place Beauvau<br />75008 Paris</p></div><p>Ces déclarations de candidature doivent être déposées, dans le respect des dates définies par la loi, par :</p><ul class=\"dark_bullet\">\n" +
            "\n" +
            "<li>les candidats personnellement ;</li>\n" +
            "\n" +
            "<li>leur remplaçant ;</li>\n" +
            "\n" +
            "<li>un représentant, spécialement mandaté.</li>\n" +
            "\n" +
            "</ul>\n" +
            "<p>Aucun autre mode de déclaration de candidature, notamment par voie postale ou télégraphique, par télécopie ou par messagerie électronique, n'est admis.</p><a name=\"eztoc18638_0_0_1_2\" id=\"eztoc18638_0_0_1_2\"></a><h4>Financement de campagne</h4><ul class=\"dark_bullet\">\n" +
            "\n" +
            "<li>Arrêté fixant les plafonds de remboursement des frais de transport : Arrêté du 5 octobre 2011 pris pour l'application de l'article L. 330-9 du code électoral</li>\n" +
            "\n" +
            "</ul>\n" +
            "<ul class=\"dark_bullet\">\n" +
            "\n" +
            "<li>Arrêté fixant la liste des pays dans lesquels il est possible d'ouvrir un compte spécial : Arrêté du 5 octobre 2011 pris pour l'application de l'article L. 330-6-1 du code électoral</li>\n" +
            "\n" +
            "</ul>\n" +
            "<a name=\"eztoc18638_0_1\" id=\"eztoc18638_0_1\"></a><h2>Modalités de vote</h2><p>Les Français établis hors de France votent, selon les cas, soit directement dans un bureau de vote ouvert dans une ambassade ou un poste consulaire, soit dans leur commune d'inscription en France. 692 787 Français résidant à l'étranger étaient inscrits sur les listes électorales au 31 mars 2006.</p><a name=\"eztoc18638_0_1_2\" id=\"eztoc18638_0_1_2\"></a><h3>Le vote des Français établis hors de France dans un bureau de vote ouvert dans une ambassade ou un poste consulaire</h3><a name=\"eztoc18638_0_1_2_3\" id=\"eztoc18638_0_1_2_3\"></a><h4>L'inscription sur la liste électorale consulaire</h4><p>Les Français établis hors de France peuvent voter directement dans un bureau de vote ouvert dans l'ambassade ou le poste consulaire situé dans la circonscription consulaire où ils ont leur résidence sous réserve de leur inscription préalable sur la liste électorale consulaire correspondante.</p><p>L'inscription sur la liste électorale consulaire est automatique pour tous les Français inscrits au registre des Français établis hors de France de la circonscription consulaire, sauf opposition de leur part. Pour les Français qui ne sont pas inscrits au registre des Français établis hors de France, l'inscription se fait à la demande des électeurs à l'ambassade ou au consulat qui se situe dans la circonscription consulaire où ils ont leur résidence.</p><a name=\"eztoc18638_0_1_2_4\" id=\"eztoc18638_0_1_2_4\"></a><h4>Les élections concernées :</h4><p>Les élections pour lesquelles les Français établis hors de France peuvent voter dans une ambassade ou un poste consulaire sont les suivantes :</p><ul class=\"dark_bullet\">\n" +
            "\n" +
            "<li>élection du Président de la République ;</li>\n" +
            "\n" +
            "<li>référendum ;</li>\n" +
            "\n" +
            "<li>élection à l'Assemblée des Français de l'étranger.</li>\n" +
            "\n" +
            "</ul>\n" +
            "<a name=\"eztoc18638_0_1_3\" id=\"eztoc18638_0_1_3\"></a><h3>Le vote des Français établis hors de France dans leur commune d'inscription en France</h3><a name=\"eztoc18638_0_1_3_5\" id=\"eztoc18638_0_1_3_5\"></a><h4>L'inscription sur la liste électorale d'une commune de France</h4><p>Les Français établis hors de France peuvent demander à être inscrits sur une liste électorale en France.</p><p>En application de l'article L.11 du code électoral, ils peuvent s'inscrire, comme l'ensemble des Français :</p><ul class=\"dark_bullet\">\n" +
            "\n" +
            "<li>soit sur la liste de la commune dans laquelle ils ont leur domicile ;</li>\n" +
            "\n" +
            "<li>soit sur la liste de la commune au titre de laquelle ils figurent pour la cinquième fois sans interruption au rôle de l'une des contributions directes communales (taxes foncières, taxe d'habitation).</li>\n" +
            "\n" +
            "</ul>\n" +
            "<p>Ils peuvent en outre, s'ils sont inscrits au registre des Français établis hors de France de la circonscription consulaire dans laquelle ils ont leur résidence, être inscrits sur la liste électorale de l'une des communes suivantes, conformément à l'article L.12 du code électoral :</p><ul class=\"dark_bullet\">\n" +
            "\n" +
            "<li>commune de naissance ;</li>\n" +
            "\n" +
            "<li>commune de leur dernier domicile ;</li>\n" +
            "\n" +
            "<li>commune de leur dernière résidence, à condition que cette résidence ait duré au moins six mois ;</li>\n" +
            "\n" +
            "<li>commune où est né, est inscrit ou a été inscrit sur la liste électorale un(e) de leurs ascendant(e)s commune sur la liste électorale de laquelle est inscrit ou a été inscrit un de leurs parents jusqu'au quatrième degré.</li>\n" +
            "\n" +
            "</ul>\n" +
            "<p>Par ailleurs, l'article L.14 du code électoral prévoit que les Français inscrits au registre des Français établis hors de France de la circonscription consulaire dans laquelle ils ont leur résidence et les conjoints des militaires de carrière ou liés par contrat peuvent également, sur justification des liens du mariage, demander leur inscription sur la liste électorale sur laquelle est inscrit leur conjoint.</p><a name=\"eztoc18638_0_1_3_6\" id=\"eztoc18638_0_1_3_6\"></a><h4>Les élections concernées :</h4><p>Les Français établis hors de France, inscrits sur une liste électorale en France, participent à toutes les élections, dans les conditions de droit commun, personnellement ou par procuration.</p><p>Ils peuvent choisir de voter à l'étranger pour l'élection du Président de la République et le référendum. Dans ce cas, ce choix sera porté sur la liste électorale et leur droit de vote en France, pour l'élection du Président de la République et le référendum, sera neutralisé. Ils ne pourront alors voter en France que pour les élections municipales, cantonales, régionales, législatives et européennes.</p><a name=\"eztoc18638_0_1_3_7\" id=\"eztoc18638_0_1_3_7\"></a><h4>Le vote par procuration</h4><p>Les Français établis hors de France qui ne peuvent pas se déplacer pour voter personnellement dans leur commune ou le bureau de vote de leur circonscription consulaire doivent, pour pouvoir voter, faire établir une procuration.</p><p>La personne qui souhaite faire établir une procuration (mandant) doit se présenter personnellement munie d'une pièce d'identité et attester sur l'honneur être dans l'impossibilité de se rendre au bureau de vote le jour du scrutin. Elle doit fournir les renseignements suivants : nom, prénoms, date de naissance et adresse de son mandataire (personne à qui le mandant donne procuration). Le mandataire doit jouir de ses droits électoraux et être inscrit sur la même liste électorale consulaire ou dans la même commune que le mandant.</p><p>La procuration est établie :</p><ul class=\"dark_bullet\">\n" +
            "\n" +
            "<li>à l'étranger, par l'ambassadeur pourvu d'une circonscription consulaire, le chef de poste consulaire ou un consul honoraire de nationalité française habilité à cet effet par arrêté du ministre des affaires étrangères ;</li>\n" +
            "\n" +
            "<li>en France, au tribunal d'instance, au commissariat de police ou à la gendarmerie du lieu d'inscription.</li>\n" +
            "\n" +
            "</ul>\n" +
            "<p>\n" +
            "Si la procuration est établie à l'étranger pour un vote en France, c'est l'ambassade ou le poste consulaire qui se chargera de la faire parvenir à la commune d'inscription du mandant. La démarche doit être effectuée suffisamment tôt pour que le formulaire de procuration parvienne à la commune avant le jour du scrutin.<br />La procuration peut être établie pour l'un des deux tours ou les deux tours de scrutin. Sa durée peut également être portée à trois ans maximum à compter de sa date d'établissement.</p>\n" +
            "</div>\n" +
            "</div>" +
            "\t</div>" +

            "</body>\n" +
            "</html>";


    public static String infoCle3= "<!DOCTYPE html>\n" +
            "<html>\n" +
            "    <head>\n" +
            "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" +
            "    </head>\n" +
            "\n" +
            "    <body>\n" +
            "<h1>Le système électoral</h1>" +
            "<h2>Quelques principes :</h2><ul class=\"dark_bullet\">\n" +
            "\n" +
            "<li>Le vote est universel : le droit de vote appartient à tous les citoyens en âge d'être électeur. </li>\n" +
            "\n" +
            "<li>Le vote est strictement personnel</li>\n" +
            "\n" +
            "<li>Le vote est libre</li>\n" +
            "\n" +
            "<li>Le vote est secret : personne ne doit chercher à connaître ni à&nbsp; contrôler le vote d'un électeur.</li>\n" +
            "\n" +
            "</ul>\n" +
            "<p>Des dispositions matérielles sont prévues dans les bureaux de vote pour protéger la liberté et le secret du vote. La principale est le passage obligatoire par l'isoloir où, à l'abri des regards, l'électeur mettra dans une enveloppe le bulletin de son choix. Il le dépose ensuite dans l'urne électorale transparente et signe en face de son nom sur la liste électorale.</p><a name=\"eztoc16293_0_2\" id=\"eztoc16293_0_2\"></a><h2>Être électeur</h2><p>Pour avoir la qualité d'électeur, il faut être de nationalité française, être âgé de 18 ans révolus et jouir de ses droits civils et politiques. De plus, le droit de vote est subordonné à l'inscription sur une liste électorale.</p><p>Une dérogation au principe de nationalité a été apportée par le traité de Maastricht, ratifié en septembre 1992. Les ressortissants communautaires ont désormais le droit de vote aux élections européennes et municipales sous réserve qu'ils soient inscrits sur des listes électorales complémentaires.</p><a name=\"eztoc16293_0_3\" id=\"eztoc16293_0_3\"></a><h2>Être éligible</h2><p>L'éligibilité est la possibilité de se présenter à une élection. Pour être éligible à une élection, il faut avant tout être électeur et de nationalité française mais des conditions spécifiques peuvent exister selon les scrutins, notamment celle relative au lien personnel entre le candidat et la collectivité.</p><p>La condition d'âge diffère également selon l'élection :</p><ul class=\"dark_bullet\">\n" +
            "\n" +
            "<li>18 ans pour les élections municipales, cantonales et régionales et législatives,</li>\n" +
            "\n" +
            "<li>24 ans pour les élections sénatoriales.</li>\n" +
            "\n" +
            "</ul>\n" +
            "<p>La condition de nationalité est élargie pour les élections municipales et les élections européennes pour lesquelles le candidat peut avoir la nationalité d'un des états membres de l'Union européenne.</p>\n" +
            "    </div>\n" +
            "    </div>\n" +
            "</div>" +
            "</body>\n" +
            "</html>";

}
