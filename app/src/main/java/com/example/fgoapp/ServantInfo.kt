class ServantInfo : ArrayList<ServantInfo.ServantInfoItem>(){
    data class ServantInfoItem(
        val appendPassive: List<AppendPassive>,
        val appendSkillMaterials: AppendSkillMaterials,
        val ascensionAdd: AscensionAdd,
        val ascensionImage: List<AscensionImage>,
        val ascensionMaterials: AscensionMaterials,
        val atkBase: Int,
        val atkGrowth: List<Int>,
        val atkMax: Int,
        val attribute: String,
        val battleName: String,
        val bondEquip: Int,
        val bondGrowth: List<Int>,
        val cardDetails: CardDetails,
        val cards: List<String>,
        val className: String,
        val classPassive: List<ClassPassive>,
        val coin: Coin,
        val collectionNo: Int,
        val cost: Int,
        val costumeMaterials: CostumeMaterials,
        val expFeed: List<Int>,
        val expGrowth: List<Int>,
        val extraAssets: ExtraAssets,
        val extraPassive: List<ExtraPassive>,
        val flag: String,
        val gender: String,
        val growthCurve: Int,
        val hitsDistribution: HitsDistribution,
        val hpBase: Int,
        val hpGrowth: List<Int>,
        val hpMax: Int,
        val id: Int,
        val instantDeathChance: Int,
        val lvMax: Int,
        val name: String,
        val noblePhantasms: List<NoblePhantasm>,
        val originalBattleName: String,
        val originalName: String,
        val rarity: Int,
        val relateQuestIds: List<Int>,
        val ruby: String,
        val script: Script,
        val skillMaterials: SkillMaterials,
        val skills: List<Skill>,
        val starAbsorb: Int,
        val starGen: Int,
        val svtChange: List<SvtChange>,
        val traitAdd: List<TraitAdd>,
        val traits: List<Trait>,
        val trialQuestIds: List<Int>,
        val type: String,
        val valentineEquip: List<Int>,
        val valentineScript: List<ValentineScript>
    ) {
        data class AppendPassive(
            val num: Int,
            val priority: Int,
            val skill: Skill,
            val unlockMaterials: List<UnlockMaterial>
        ) {
            data class Skill(
                val actIndividuality: List<Any>,
                val coolDown: List<Int>,
                val detail: String,
                val extraPassive: List<Any>,
                val functions: List<Function>,
                val icon: String,
                val id: Int,
                val name: String,
                val originalName: String,
                val ruby: String,
                val script: Script,
                val skillAdd: List<Any>,
                val type: String,
                val unmodifiedDetail: String
            ) {
                data class Function(
                    val buffs: List<Buff>,
                    val funcGroup: List<Any>,
                    val funcId: Int,
                    val funcPopupIcon: String,
                    val funcPopupText: String,
                    val funcTargetTeam: String,
                    val funcTargetType: String,
                    val funcType: String,
                    val funcquestTvals: List<Any>,
                    val functvals: List<Any>,
                    val svals: List<Sval>
                ) {
                    data class Buff(
                        val buffGroup: Int,
                        val ckOpIndv: List<CkOpIndv>,
                        val ckSelfIndv: List<CkSelfIndv>,
                        val detail: String,
                        val icon: String,
                        val id: Int,
                        val maxRate: Int,
                        val name: String,
                        val script: Script,
                        val tvals: List<Tval>,
                        val type: String,
                        val vals: List<Val>
                    ) {
                        data class CkOpIndv(
                            val id: Int,
                            val name: String
                        )
    
                        data class CkSelfIndv(
                            val id: Int,
                            val name: String
                        )
    
                        data class Script(
                            val iNDIVIDUALITIE: INDIVIDUALITIE
                        ) {
                            data class INDIVIDUALITIE(
                                val id: Int,
                                val name: String
                            )
                        }
    
                        data class Tval(
                            val id: Int,
                            val name: String
                        )
    
                        data class Val(
                            val id: Int,
                            val name: String
                        )
                    }
    
                    data class Sval(
                        val Count: Int,
                        val Rate: Int,
                        val ShowState: Int,
                        val Turn: Int,
                        val Value: Int
                    )
                }
    
                class Script
            }
    
            data class UnlockMaterial(
                val amount: Int,
                val item: Item
            ) {
                data class Item(
                    val background: String,
                    val detail: String,
                    val dropPriority: Int,
                    val icon: String,
                    val id: Int,
                    val individuality: List<Any>,
                    val itemSelects: List<Any>,
                    val name: String,
                    val originalName: String,
                    val priority: Int,
                    val type: String,
                    val uses: List<Any>
                )
            }
        }
    
        data class AppendSkillMaterials(
            val `1`: X1,
            val `2`: X2,
            val `3`: X3,
            val `4`: X4,
            val `5`: X5,
            val `6`: X6,
            val `7`: X7,
            val `8`: X8,
            val `9`: X9
        ) {
            data class X1(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X2(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X3(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X4(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X5(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X6(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X7(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X8(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X9(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
        }
    
        data class AscensionAdd(
            val charaGraphChange: CharaGraphChange,
            val charaGraphChangeCommonRelease: CharaGraphChangeCommonRelease,
            val faceChange: FaceChange,
            val faceChangeCommonRelease: FaceChangeCommonRelease,
            val individuality: Individuality,
            val lvMax: LvMax,
            val originalOverWriteServantBattleName: OriginalOverWriteServantBattleName,
            val originalOverWriteServantName: OriginalOverWriteServantName,
            val originalOverWriteTDName: OriginalOverWriteTDName,
            val overWriteServantBattleName: OverWriteServantBattleName,
            val overWriteServantName: OverWriteServantName,
            val overWriteTDFileName: OverWriteTDFileName,
            val overWriteTDName: OverWriteTDName,
            val overWriteTDRank: OverWriteTDRank,
            val overWriteTDRuby: OverWriteTDRuby,
            val overWriteTDTypeText: OverWriteTDTypeText,
            val voicePrefix: VoicePrefix
        ) {
            data class CharaGraphChange(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
                class Costume
            }
    
            data class CharaGraphChangeCommonRelease(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
                class Costume
            }
    
            data class FaceChange(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
                class Costume
            }
    
            data class FaceChangeCommonRelease(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
                class Costume
            }
    
            data class Individuality(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `0`: List<X0>,
                    val `1`: List<X1>,
                    val `2`: List<X2>,
                    val `3`: List<X3>,
                    val `4`: List<X4>,
                    val `9`: List<Any>
                ) {
                    data class X0(
                        val id: Int,
                        val name: String
                    )
    
                    data class X1(
                        val id: Int,
                        val name: String
                    )
    
                    data class X2(
                        val id: Int,
                        val name: String
                    )
    
                    data class X3(
                        val id: Int,
                        val name: String
                    )
    
                    data class X4(
                        val id: Int,
                        val name: String
                    )
                }
    
                data class Costume(
                    val `100130`: List<Any>,
                    val `100230`: List<Any>,
                    val `100530`: List<Any>,
                    val `100540`: List<Any>,
                    val `100830`: List<Any>,
                    val `100930`: List<Any>,
                    val `101230`: List<Any>,
                    val `102730`: List<Any>,
                    val `102830`: List<Any>,
                    val `102840`: List<Any>,
                    val `102850`: List<Any>,
                    val `102930`: List<Any>,
                    val `103330`: List<Any>,
                    val `103630`: List<Any>,
                    val `1100230`: List<Any>,
                    val `1100330`: List<Any>,
                    val `1100930`: List<Any>,
                    val `200130`: List<Any>,
                    val `200330`: List<Any>,
                    val `201530`: List<Any>,
                    val `202330`: List<Any>,
                    val `2300230`: List<Any>,
                    val `2300240`: List<Any>,
                    val `300430`: List<Any>,
                    val `301330`: List<Any>,
                    val `303030`: List<Any>,
                    val `303830`: List<Any>,
                    val `304030`: List<Any>,
                    val `400430`: List<Any>,
                    val `400830`: List<Any>,
                    val `401330`: List<Any>,
                    val `403530`: List<Any>,
                    val `500830`: List<Any>,
                    val `501830`: List<Any>,
                    val `502830`: List<Any>,
                    val `601830`: List<Any>,
                    val `601930`: List<Any>,
                    val `603330`: List<Any>,
                    val `603630`: List<Any>,
                    val `603640`: List<Any>,
                    val `700630`: List<Any>,
                    val `702730`: List<Any>,
                    val `702830`: List<Any>,
                    val `703630`: List<Any>,
                    val `800130`: List<Any>,
                    val `800140`: List<Any>,
                    val `800150`: List<Any>,
                    val `800160`: List<Any>,
                    val `900230`: List<Any>,
                    val `900730`: List<Any>,
                    val `900740`: List<Any>
                )
            }
    
            data class LvMax(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `0`: Int,
                    val `1`: Int,
                    val `2`: Int,
                    val `3`: Int,
                    val `4`: Int
                )
    
                class Costume
            }
    
            data class OriginalOverWriteServantBattleName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `0`: String,
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                )
    
                data class Costume(
                    val `11`: String
                )
            }
    
            data class OriginalOverWriteServantName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `0`: String,
                    val `1`: String,
                    val `2`: String
                )
    
                class Costume
            }
    
            data class OriginalOverWriteTDName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                )
    
                class Costume
            }
    
            data class OverWriteServantBattleName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `0`: String,
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                )
    
                data class Costume(
                    val `11`: String
                )
            }
    
            data class OverWriteServantName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `0`: String,
                    val `1`: String,
                    val `2`: String
                )
    
                class Costume
            }
    
            data class OverWriteTDFileName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                )
    
                class Costume
            }
    
            data class OverWriteTDName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                )
    
                class Costume
            }
    
            data class OverWriteTDRank(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
                class Costume
            }
    
            data class OverWriteTDRuby(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                )
    
                class Costume
            }
    
            data class OverWriteTDTypeText(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
                class Costume
            }
    
            data class VoicePrefix(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `0`: Int,
                    val `1`: Int,
                    val `2`: Int,
                    val `3`: Int,
                    val `4`: Int,
                    val `9`: Int
                )
    
                data class Costume(
                    val `100130`: Int,
                    val `100230`: Int,
                    val `100530`: Int,
                    val `100540`: Int,
                    val `100830`: Int,
                    val `100930`: Int,
                    val `101230`: Int,
                    val `102730`: Int,
                    val `102830`: Int,
                    val `102840`: Int,
                    val `102850`: Int,
                    val `102930`: Int,
                    val `103330`: Int,
                    val `103630`: Int,
                    val `1100230`: Int,
                    val `1100330`: Int,
                    val `1100930`: Int,
                    val `200130`: Int,
                    val `200330`: Int,
                    val `201530`: Int,
                    val `202330`: Int,
                    val `2300230`: Int,
                    val `2300240`: Int,
                    val `300430`: Int,
                    val `301330`: Int,
                    val `303030`: Int,
                    val `303830`: Int,
                    val `304030`: Int,
                    val `400430`: Int,
                    val `400830`: Int,
                    val `401330`: Int,
                    val `403530`: Int,
                    val `500830`: Int,
                    val `501830`: Int,
                    val `502830`: Int,
                    val `601830`: Int,
                    val `601930`: Int,
                    val `603330`: Int,
                    val `603630`: Int,
                    val `603640`: Int,
                    val `700630`: Int,
                    val `702730`: Int,
                    val `702830`: Int,
                    val `703630`: Int,
                    val `800130`: Int,
                    val `800140`: Int,
                    val `800150`: Int,
                    val `800160`: Int,
                    val `900230`: Int,
                    val `900730`: Int,
                    val `900740`: Int
                )
            }
        }
    
        data class AscensionImage(
            val condNum: Int,
            val condTargetId: Int,
            val condType: String,
            val defaultLimitCount: Int,
            val limitCount: Int,
            val priority: Int
        )
    
        data class AscensionMaterials(
            val `0`: X0,
            val `1`: X1,
            val `2`: X2,
            val `3`: X3
        ) {
            data class X0(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X1(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X2(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X3(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
        }
    
        data class CardDetails(
            val arts: Arts,
            val buster: Buster,
            val extra: Extra,
            val quick: Quick
        ) {
            data class Arts(
                val attackIndividuality: List<AttackIndividuality>
            ) {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                )
            }
    
            data class Buster(
                val attackIndividuality: List<AttackIndividuality>
            ) {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                )
            }
    
            data class Extra(
                val attackIndividuality: List<AttackIndividuality>
            ) {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                )
            }
    
            data class Quick(
                val attackIndividuality: List<AttackIndividuality>
            ) {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                )
            }
        }
    
        data class ClassPassive(
            val actIndividuality: List<Any>,
            val coolDown: List<Int>,
            val detail: String,
            val extraPassive: List<Any>,
            val functions: List<Function>,
            val icon: String,
            val id: Int,
            val name: String,
            val originalName: String,
            val ruby: String,
            val script: Script,
            val skillAdd: List<Any>,
            val type: String,
            val unmodifiedDetail: String
        ) {
            data class Function(
                val buffs: List<Buff>,
                val funcGroup: List<Any>,
                val funcId: Int,
                val funcPopupIcon: String,
                val funcPopupText: String,
                val funcTargetTeam: String,
                val funcTargetType: String,
                val funcType: String,
                val funcquestTvals: List<Any>,
                val functvals: List<Functval>,
                val svals: List<Sval>
            ) {
                data class Buff(
                    val buffGroup: Int,
                    val ckOpIndv: List<CkOpIndv>,
                    val ckSelfIndv: List<CkSelfIndv>,
                    val detail: String,
                    val icon: String,
                    val id: Int,
                    val maxRate: Int,
                    val name: String,
                    val script: Script,
                    val tvals: List<Tval>,
                    val type: String,
                    val vals: List<Val>
                ) {
                    data class CkOpIndv(
                        val id: Int,
                        val name: String
                    )
    
                    data class CkSelfIndv(
                        val id: Int,
                        val name: String
                    )
    
                    data class Script(
                        val iNDIVIDUALITIE: INDIVIDUALITIE,
                        val checkIndvType: Int,
                        val relationId: RelationId
                    ) {
                        data class INDIVIDUALITIE(
                            val id: Int,
                            val name: String
                        )
    
                        data class RelationId(
                            val atkSide: AtkSide,
                            val defSide: DefSide
                        ) {
                            data class AtkSide(
                                val alterEgo: AlterEgo
                            ) {
                                data class AlterEgo(
                                    val ruler: Ruler
                                ) {
                                    data class Ruler(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
                            }
    
                            class DefSide
                        }
                    }
    
                    data class Tval(
                        val id: Int,
                        val name: String
                    )
    
                    data class Val(
                        val id: Int,
                        val name: String
                    )
                }
    
                data class Functval(
                    val id: Int,
                    val name: String,
                    val negative: Boolean
                )
    
                data class Sval(
                    val Count: Int,
                    val OnField: Int,
                    val OnFieldCount: Int,
                    val Rate: Int,
                    val ShowQuestNoEffect: Int,
                    val ShowState: Int,
                    val Turn: Int,
                    val UseRate: Int,
                    val Value: Int,
                    val Value2: Int
                )
            }
    
            class Script
        }
    
        data class Coin(
            val item: Item,
            val summonNum: Int
        ) {
            data class Item(
                val background: String,
                val detail: String,
                val dropPriority: Int,
                val icon: String,
                val id: Int,
                val individuality: List<Any>,
                val itemSelects: List<Any>,
                val name: String,
                val originalName: String,
                val priority: Int,
                val type: String,
                val uses: List<Any>
            )
        }
    
        data class CostumeMaterials(
            val `100130`: X100130,
            val `100230`: X100230,
            val `100530`: X100530,
            val `100540`: X100540,
            val `100830`: X100830,
            val `100930`: X100930,
            val `101230`: X101230,
            val `102730`: X102730,
            val `102830`: X102830,
            val `102840`: X102840,
            val `102850`: X102850,
            val `102930`: X102930,
            val `103330`: X103330,
            val `103630`: X103630,
            val `1100230`: X1100230,
            val `1100330`: X1100330,
            val `1100930`: X1100930,
            val `200130`: X200130,
            val `200330`: X200330,
            val `201530`: X201530,
            val `202330`: X202330,
            val `2300230`: X2300230,
            val `2300240`: X2300240,
            val `300430`: X300430,
            val `301330`: X301330,
            val `303030`: X303030,
            val `303830`: X303830,
            val `304030`: X304030,
            val `400430`: X400430,
            val `401330`: X401330,
            val `403530`: X403530,
            val `500830`: X500830,
            val `501830`: X501830,
            val `502830`: X502830,
            val `601830`: X601830,
            val `601930`: X601930,
            val `603330`: X603330,
            val `603630`: X603630,
            val `603640`: X603640,
            val `700630`: X700630,
            val `702730`: X702730,
            val `702830`: X702830,
            val `703630`: X703630,
            val `800130`: X800130,
            val `800160`: X800160,
            val `900730`: X900730,
            val `900740`: X900740
        ) {
            data class X100130(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X100230(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X100530(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X100540(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X100830(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X100930(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X101230(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X102730(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X102830(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X102840(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X102850(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X102930(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X103330(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X103630(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X1100230(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X1100330(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X1100930(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X200130(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X200330(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X201530(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X202330(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X2300230(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X2300240(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X300430(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X301330(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X303030(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X303830(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X304030(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X400430(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X401330(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X403530(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X500830(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X501830(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X502830(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X601830(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X601930(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X603330(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X603630(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X603640(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X700630(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X702730(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X702830(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X703630(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X800130(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X800160(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X900730(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X900740(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
        }
    
        data class ExtraAssets(
            val charaFigure: CharaFigure,
            val charaFigureForm: CharaFigureForm,
            val charaFigureMulti: CharaFigureMulti,
            val charaGraph: CharaGraph,
            val charaGraphChange: CharaGraphChange,
            val charaGraphEx: CharaGraphEx,
            val charaGraphName: CharaGraphName,
            val commands: Commands,
            val equipFace: EquipFace,
            val faces: Faces,
            val facesChange: FacesChange,
            val image: Image,
            val narrowFigure: NarrowFigure,
            val narrowFigureChange: NarrowFigureChange,
            val spriteModel: SpriteModel,
            val status: Status
        ) {
            data class CharaFigure(
                val ascension: Ascension,
                val costume: Costume,
                val story: Story
            ) {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String
                )
    
                data class Costume(
                    val `100130`: String,
                    val `100230`: String,
                    val `100530`: String,
                    val `100540`: String,
                    val `100830`: String,
                    val `100930`: String,
                    val `101230`: String,
                    val `102730`: String,
                    val `102830`: String,
                    val `102840`: String,
                    val `102850`: String,
                    val `102930`: String,
                    val `103330`: String,
                    val `103630`: String,
                    val `1100230`: String,
                    val `1100330`: String,
                    val `1100930`: String,
                    val `200130`: String,
                    val `200330`: String,
                    val `201530`: String,
                    val `202330`: String,
                    val `2300230`: String,
                    val `2300240`: String,
                    val `300430`: String,
                    val `301330`: String,
                    val `303030`: String,
                    val `303830`: String,
                    val `304030`: String,
                    val `400430`: String,
                    val `400830`: String,
                    val `401330`: String,
                    val `403530`: String,
                    val `500830`: String,
                    val `501830`: String,
                    val `502830`: String,
                    val `601830`: String,
                    val `601930`: String,
                    val `603330`: String,
                    val `603630`: String,
                    val `603640`: String,
                    val `700630`: String,
                    val `702730`: String,
                    val `702830`: String,
                    val `703630`: String,
                    val `800130`: String,
                    val `800140`: String,
                    val `800150`: String,
                    val `800160`: String,
                    val `900230`: String,
                    val `900730`: String,
                    val `900740`: String
                )
    
                data class Story(
                    val `1012300`: String,
                    val `1098116300`: String,
                    val `1098116310`: String,
                    val `1098116320`: String,
                    val `1098116400`: String,
                    val `1098116500`: String,
                    val `1098116600`: String,
                    val `1098116610`: String,
                    val `1098116620`: String,
                    val `1098116630`: String,
                    val `1098116700`: String,
                    val `1098116800`: String,
                    val `1098116810`: String,
                    val `1098116900`: String,
                    val `1098117100`: String,
                    val `1098117500`: String,
                    val `1098117600`: String,
                    val `1098117700`: String,
                    val `1098117710`: String,
                    val `1098117720`: String,
                    val `1098117730`: String,
                    val `1098117800`: String,
                    val `1098117900`: String,
                    val `1098117910`: String,
                    val `1098118100`: String,
                    val `1098118110`: String,
                    val `1098118200`: String,
                    val `1098118300`: String,
                    val `1098118700`: String,
                    val `1098119100`: String,
                    val `1098119200`: String,
                    val `1098119210`: String,
                    val `1098119300`: String,
                    val `1098119400`: String,
                    val `1098119500`: String,
                    val `1098119510`: String,
                    val `1098119600`: String,
                    val `1098119700`: String,
                    val `1098119800`: String,
                    val `1098119810`: String,
                    val `1098119900`: String,
                    val `1098120000`: String,
                    val `1098120100`: String,
                    val `1098120110`: String,
                    val `1098120200`: String,
                    val `1098121400`: String,
                    val `1098121500`: String,
                    val `1098121700`: String,
                    val `1098122100`: String,
                    val `1098122200`: String,
                    val `1098122300`: String,
                    val `1098122400`: String,
                    val `1098122500`: String,
                    val `1098122700`: String,
                    val `1098122800`: String,
                    val `1098122820`: String,
                    val `1098124000`: String,
                    val `1098124010`: String,
                    val `1098124510`: String,
                    val `1098124600`: String,
                    val `1098124700`: String,
                    val `1098124900`: String,
                    val `1098124910`: String,
                    val `1098125000`: String,
                    val `1098125100`: String,
                    val `1098125200`: String,
                    val `1098125300`: String,
                    val `1098125400`: String,
                    val `1098125500`: String,
                    val `1098125600`: String,
                    val `1098125610`: String,
                    val `1098125800`: String,
                    val `1098126100`: String,
                    val `1098126300`: String,
                    val `1098128000`: String,
                    val `1098128100`: String,
                    val `1098128210`: String,
                    val `1098128220`: String,
                    val `1098128300`: String,
                    val `1098128310`: String,
                    val `1098128800`: String,
                    val `1098129000`: String,
                    val `1098129100`: String,
                    val `1098129200`: String,
                    val `1098129300`: String,
                    val `1098129400`: String,
                    val `1098129500`: String,
                    val `1098129600`: String,
                    val `1098129700`: String,
                    val `1098129800`: String,
                    val `1098129900`: String,
                    val `1098130000`: String,
                    val `1098130100`: String,
                    val `1098130200`: String,
                    val `1098130300`: String,
                    val `1098130400`: String,
                    val `1098130500`: String,
                    val `1098130600`: String,
                    val `1098130700`: String,
                    val `1098135000`: String,
                    val `1098136000`: String,
                    val `1098137000`: String,
                    val `1098138000`: String,
                    val `1098139000`: String,
                    val `1098140000`: String,
                    val `109814300`: String,
                    val `1098144000`: String,
                    val `1098144010`: String,
                    val `1098145000`: String,
                    val `1098146000`: String,
                    val `1098147000`: String,
                    val `1098148000`: String,
                    val `1098149000`: String,
                    val `1098150000`: String,
                    val `1098151000`: String,
                    val `1098153000`: String,
                    val `1098153200`: String,
                    val `1098153410`: String,
                    val `1098154200`: String,
                    val `1098154210`: String,
                    val `1098154300`: String,
                    val `1098154400`: String,
                    val `1098154500`: String,
                    val `1098154510`: String,
                    val `1098154600`: String,
                    val `1098154900`: String,
                    val `1098155000`: String,
                    val `1098155100`: String,
                    val `1098155200`: String,
                    val `1098155300`: String,
                    val `1098155310`: String,
                    val `1098155400`: String,
                    val `1098155500`: String,
                    val `1098155600`: String,
                    val `1098155700`: String,
                    val `1098155800`: String,
                    val `1098155900`: String,
                    val `1098156000`: String,
                    val `1098156100`: String,
                    val `1098156200`: String,
                    val `1098156500`: String,
                    val `1098156600`: String,
                    val `1098156700`: String,
                    val `1098156800`: String,
                    val `1098156900`: String,
                    val `1098157100`: String,
                    val `1098157200`: String,
                    val `1098157300`: String,
                    val `1098157400`: String,
                    val `1098157500`: String,
                    val `1098157510`: String,
                    val `1098157600`: String,
                    val `1098157700`: String,
                    val `1098157800`: String,
                    val `1098157900`: String,
                    val `1098158000`: String,
                    val `1098158100`: String,
                    val `1098158310`: String,
                    val `1098158600`: String,
                    val `1098159400`: String,
                    val `1098159410`: String,
                    val `1098159420`: String,
                    val `1098159900`: String,
                    val `1098160100`: String,
                    val `1098160500`: String,
                    val `1098160910`: String,
                    val `1098162000`: String,
                    val `1098162100`: String,
                    val `1098162300`: String,
                    val `1098162400`: String,
                    val `1098162500`: String,
                    val `1098162600`: String,
                    val `1098163200`: String,
                    val `1098163300`: String,
                    val `1098163400`: String,
                    val `1098163600`: String,
                    val `1098163700`: String,
                    val `1098163710`: String,
                    val `1098163720`: String,
                    val `1098163800`: String,
                    val `1098164600`: String,
                    val `1098164700`: String,
                    val `1098164800`: String,
                    val `1098164900`: String,
                    val `1098164910`: String,
                    val `1098164920`: String,
                    val `1098165000`: String,
                    val `1098165100`: String,
                    val `1098165200`: String,
                    val `1098165300`: String,
                    val `1098165400`: String,
                    val `1098165700`: String,
                    val `1098165710`: String,
                    val `1098166200`: String,
                    val `1098166210`: String,
                    val `1098166400`: String,
                    val `1098166500`: String,
                    val `1098167900`: String,
                    val `1098168000`: String,
                    val `1098168210`: String,
                    val `1098168300`: String,
                    val `1098168400`: String,
                    val `1098168500`: String,
                    val `1098168600`: String,
                    val `1098168700`: String,
                    val `1098168800`: String,
                    val `1098168900`: String,
                    val `1098169000`: String,
                    val `1098169100`: String,
                    val `1098169200`: String,
                    val `1098169300`: String,
                    val `1098169400`: String,
                    val `1098169500`: String,
                    val `1098169600`: String,
                    val `1098169700`: String,
                    val `1098169900`: String,
                    val `1098169910`: String,
                    val `1098170000`: String,
                    val `1098170100`: String,
                    val `1098170200`: String,
                    val `1098170300`: String,
                    val `1098170500`: String,
                    val `1098170600`: String,
                    val `1098170700`: String,
                    val `1098171000`: String,
                    val `1098171200`: String,
                    val `1098171300`: String,
                    val `1098174800`: String,
                    val `1098174900`: String,
                    val `1098174910`: String,
                    val `1098176000`: String,
                    val `1098176600`: String,
                    val `1098176810`: String,
                    val `1098176900`: String,
                    val `1098177000`: String,
                    val `1098177100`: String,
                    val `1098177200`: String,
                    val `1098177300`: String,
                    val `1098177320`: String,
                    val `1098177600`: String,
                    val `1098177700`: String,
                    val `1098177800`: String,
                    val `1098178000`: String,
                    val `1098178800`: String,
                    val `1098179000`: String,
                    val `1098179100`: String,
                    val `1098179200`: String,
                    val `1098179300`: String,
                    val `1098179400`: String,
                    val `1098179500`: String,
                    val `1098179600`: String,
                    val `1098179700`: String,
                    val `1098179800`: String,
                    val `1098179900`: String,
                    val `1098180000`: String,
                    val `1098180100`: String,
                    val `1098180110`: String,
                    val `1098180200`: String,
                    val `1098180500`: String,
                    val `1098181000`: String,
                    val `1098181100`: String,
                    val `1098181800`: String,
                    val `1098181820`: String,
                    val `1098181910`: String,
                    val `1098182010`: String,
                    val `1098182110`: String,
                    val `1098182210`: String,
                    val `1098182310`: String,
                    val `1098182400`: String,
                    val `1098182410`: String,
                    val `1098182420`: String,
                    val `1098182500`: String,
                    val `1098182510`: String,
                    val `1098182520`: String,
                    val `1098182800`: String,
                    val `1098182810`: String,
                    val `1098182900`: String,
                    val `1098182910`: String,
                    val `1098183000`: String,
                    val `1098184000`: String,
                    val `1098184100`: String,
                    val `1098184200`: String,
                    val `1098184300`: String,
                    val `1098184310`: String,
                    val `1098184600`: String,
                    val `1098184610`: String,
                    val `1098184700`: String,
                    val `1098184800`: String,
                    val `1098184810`: String,
                    val `1098184820`: String,
                    val `1098184900`: String,
                    val `1098185000`: String,
                    val `1098185100`: String,
                    val `1098185500`: String,
                    val `1098185610`: String,
                    val `1098185800`: String,
                    val `1098185900`: String,
                    val `1098186000`: String,
                    val `1098186100`: String,
                    val `1098186200`: String,
                    val `1098186400`: String,
                    val `1098186600`: String,
                    val `1098186700`: String,
                    val `1098186710`: String,
                    val `1098186720`: String,
                    val `1098186800`: String,
                    val `1098186810`: String,
                    val `1098186820`: String,
                    val `1098187100`: String,
                    val `1098187200`: String,
                    val `1098187300`: String,
                    val `1098187400`: String,
                    val `1098187500`: String,
                    val `1098187600`: String,
                    val `1098187700`: String,
                    val `1098187800`: String,
                    val `1098187900`: String,
                    val `1098188000`: String,
                    val `1098188100`: String,
                    val `1098188200`: String,
                    val `1098188400`: String,
                    val `1098188900`: String,
                    val `1098189000`: String,
                    val `1098189010`: String,
                    val `1098189100`: String,
                    val `1098189200`: String,
                    val `1098189210`: String,
                    val `1098189400`: String,
                    val `1098189500`: String,
                    val `1098189600`: String,
                    val `1098189700`: String,
                    val `1098190300`: String,
                    val `1098190400`: String,
                    val `1098190500`: String,
                    val `1098190600`: String,
                    val `1098190700`: String,
                    val `1098190800`: String,
                    val `1098190900`: String,
                    val `1098191000`: String,
                    val `1098191110`: String,
                    val `1098192200`: String,
                    val `1098192300`: String,
                    val `1098192500`: String,
                    val `1098192600`: String,
                    val `1098192700`: String,
                    val `1098192720`: String,
                    val `1098192800`: String,
                    val `1098192900`: String,
                    val `1098192910`: String,
                    val `1098192920`: String,
                    val `1098193000`: String,
                    val `1098193700`: String,
                    val `1098193800`: String,
                    val `1098194300`: String,
                    val `1098194400`: String,
                    val `1098194410`: String,
                    val `1098196500`: String,
                    val `1098196600`: String,
                    val `1098196710`: String,
                    val `1098196800`: String,
                    val `1098196900`: String,
                    val `1098197000`: String,
                    val `1098197100`: String,
                    val `1098197200`: String,
                    val `1098197210`: String,
                    val `1098197310`: String,
                    val `1098197400`: String,
                    val `1098197410`: String,
                    val `1098197500`: String,
                    val `1098197600`: String,
                    val `1098197700`: String,
                    val `1098197710`: String,
                    val `1098197800`: String,
                    val `1098197810`: String,
                    val `1098197900`: String,
                    val `1098198000`: String,
                    val `1098198100`: String,
                    val `1098198200`: String,
                    val `1098198300`: String,
                    val `1098198420`: String,
                    val `1098198500`: String,
                    val `1098198600`: String,
                    val `1098198700`: String,
                    val `1098198800`: String,
                    val `1098198900`: String,
                    val `1098199000`: String,
                    val `1098199100`: String,
                    val `1098199200`: String,
                    val `1098199300`: String,
                    val `1098199400`: String,
                    val `1098199700`: String,
                    val `1098199710`: String,
                    val `1098200000`: String,
                    val `1098200100`: String,
                    val `1098200500`: String,
                    val `1098200510`: String,
                    val `1098200600`: String,
                    val `1098201100`: String,
                    val `1098201500`: String,
                    val `1098201600`: String,
                    val `1098201900`: String,
                    val `1098202000`: String,
                    val `1098202100`: String,
                    val `1098202200`: String,
                    val `1098202400`: String,
                    val `1098202500`: String,
                    val `1098203900`: String,
                    val `1098204000`: String,
                    val `1098204100`: String,
                    val `1098204300`: String,
                    val `1098204400`: String,
                    val `1098204600`: String,
                    val `1098204700`: String,
                    val `1098204900`: String,
                    val `1098205000`: String,
                    val `1098205100`: String,
                    val `1098205200`: String,
                    val `1098205300`: String,
                    val `1098205500`: String,
                    val `1098205600`: String,
                    val `1098205700`: String,
                    val `1098206100`: String,
                    val `1098206110`: String,
                    val `1098206200`: String,
                    val `1098206310`: String,
                    val `1098206700`: String,
                    val `1098206800`: String,
                    val `1098206900`: String,
                    val `1098207000`: String,
                    val `1098207100`: String,
                    val `1098207200`: String,
                    val `1098208100`: String,
                    val `1098208200`: String,
                    val `1098209500`: String,
                    val `1098211000`: String,
                    val `1098211010`: String,
                    val `1098212300`: String,
                    val `1098212310`: String,
                    val `1098212320`: String,
                    val `1098212330`: String,
                    val `1098212340`: String,
                    val `1098212600`: String,
                    val `1098212700`: String,
                    val `1098212800`: String,
                    val `1098212900`: String,
                    val `1098213000`: String,
                    val `1098213100`: String,
                    val `1098213200`: String,
                    val `1098215300`: String,
                    val `1098215310`: String,
                    val `1098216600`: String,
                    val `1098216700`: String,
                    val `1098217700`: String,
                    val `1098217710`: String,
                    val `1098217800`: String,
                    val `1098218300`: String,
                    val `1098218400`: String,
                    val `1098218410`: String,
                    val `1098218900`: String,
                    val `1098219000`: String,
                    val `1098219010`: String,
                    val `1098220700`: String,
                    val `1098221900`: String,
                    val `1098222000`: String,
                    val `1098222100`: String,
                    val `1098222200`: String,
                    val `1098222300`: String,
                    val `1098222400`: String,
                    val `1098222410`: String,
                    val `1098224300`: String,
                    val `1098224400`: String,
                    val `1098224500`: String,
                    val `1098224510`: String,
                    val `1098224700`: String,
                    val `1098224710`: String,
                    val `1098224720`: String,
                    val `1098224800`: String,
                    val `1098225000`: String,
                    val `1098225100`: String,
                    val `1098225200`: String,
                    val `1098225300`: String,
                    val `1098225400`: String,
                    val `1098225600`: String,
                    val `1098226100`: String,
                    val `1098226200`: String,
                    val `1098226300`: String,
                    val `1098226700`: String,
                    val `1098226800`: String,
                    val `1098226900`: String,
                    val `1098227000`: String,
                    val `1098227100`: String,
                    val `1098228300`: String,
                    val `1098230500`: String,
                    val `1098230700`: String,
                    val `1098230710`: String,
                    val `1098231500`: String,
                    val `1098231510`: String,
                    val `2009100`: String,
                    val `2009101`: String,
                    val `2009102`: String,
                    val `2009200`: String,
                    val `2009201`: String,
                    val `2009202`: String,
                    val `2025100`: String,
                    val `2025101`: String,
                    val `2025102`: String,
                    val `2025200`: String,
                    val `2025201`: String,
                    val `2025202`: String,
                    val `4009100`: String,
                    val `4009101`: String,
                    val `4009102`: String,
                    val `4009200`: String,
                    val `4009201`: String,
                    val `4009202`: String,
                    val `4030010`: String,
                    val `5009003`: String,
                    val `5009010`: String,
                    val `5009020`: String,
                    val `5009030`: String,
                    val `5009031`: String,
                    val `5009040`: String,
                    val `5009041`: String,
                    val `5009042`: String,
                    val `5028100`: String,
                    val `6007003`: String,
                    val `7038010`: String,
                    val `7038011`: String,
                    val `7038012`: String,
                    val `8001420`: String,
                    val `90000010`: String,
                    val `90000020`: String,
                    val `90010000`: String,
                    val `90010030`: String,
                    val `9003000`: String,
                    val `98001000`: String,
                    val `98013000`: String,
                    val `98019000`: String,
                    val `98051000`: String,
                    val `98052000`: String,
                    val `98052010`: String,
                    val `98052020`: String,
                    val `98052030`: String,
                    val `98052040`: String,
                    val `98052050`: String,
                    val `98052060`: String,
                    val `98052070`: String,
                    val `98052080`: String,
                    val `98053000`: String,
                    val `98053010`: String,
                    val `98054000`: String,
                    val `98060000`: String,
                    val `98061000`: String,
                    val `98062000`: String,
                    val `98065000`: String,
                    val `98065001`: String,
                    val `98066000`: String,
                    val `98067000`: String,
                    val `98068000`: String,
                    val `98069000`: String,
                    val `98070000`: String,
                    val `98071000`: String,
                    val `98072000`: String,
                    val `98073000`: String,
                    val `98074000`: String,
                    val `98076000`: String,
                    val `98079000`: String,
                    val `98079100`: String,
                    val `98085000`: String,
                    val `98086000`: String,
                    val `98086010`: String,
                    val `98086020`: String,
                    val `98086030`: String,
                    val `98088000`: String,
                    val `98089000`: String,
                    val `98093000`: String,
                    val `98094000`: String,
                    val `98095000`: String,
                    val `98096000`: String,
                    val `98097000`: String,
                    val `98100200`: String,
                    val `98100400`: String,
                    val `98100500`: String,
                    val `98102000`: String,
                    val `98102100`: String,
                    val `98102200`: String,
                    val `98102300`: String,
                    val `98102400`: String,
                    val `98102500`: String,
                    val `98102600`: String,
                    val `98102800`: String,
                    val `98103000`: String,
                    val `98103200`: String,
                    val `98103300`: String,
                    val `98103400`: String,
                    val `98103500`: String,
                    val `98103600`: String,
                    val `98103700`: String,
                    val `98103800`: String,
                    val `98103900`: String,
                    val `98104000`: String,
                    val `98104010`: String,
                    val `98104200`: String,
                    val `98104900`: String,
                    val `98105000`: String,
                    val `98105100`: String,
                    val `98105200`: String,
                    val `98105300`: String,
                    val `98105400`: String,
                    val `98105600`: String,
                    val `98105700`: String,
                    val `98105800`: String,
                    val `98106000`: String,
                    val `98106100`: String,
                    val `98106110`: String,
                    val `98106120`: String,
                    val `98106300`: String,
                    val `98106400`: String,
                    val `98106500`: String,
                    val `98106600`: String,
                    val `98106700`: String,
                    val `98106800`: String,
                    val `98106810`: String,
                    val `98106900`: String,
                    val `98106910`: String,
                    val `98107000`: String,
                    val `98107100`: String,
                    val `98107200`: String,
                    val `98107300`: String,
                    val `98107400`: String,
                    val `98108200`: String,
                    val `98108300`: String,
                    val `98108310`: String,
                    val `98108400`: String,
                    val `98108500`: String,
                    val `98108600`: String,
                    val `98108700`: String,
                    val `98108800`: String,
                    val `98109600`: String,
                    val `98109700`: String,
                    val `98110000`: String,
                    val `98110600`: String,
                    val `98110700`: String,
                    val `98110800`: String,
                    val `98111000`: String,
                    val `98111001`: String,
                    val `98111002`: String,
                    val `98111200`: String,
                    val `98111302`: String,
                    val `98111500`: String,
                    val `98111600`: String,
                    val `98111610`: String,
                    val `98112200`: String,
                    val `98112700`: String,
                    val `98112800`: String,
                    val `98112900`: String,
                    val `98113200`: String,
                    val `98113400`: String,
                    val `98113500`: String,
                    val `98113600`: String,
                    val `98113700`: String,
                    val `98113900`: String,
                    val `98113910`: String,
                    val `98113920`: String,
                    val `98113930`: String,
                    val `98113940`: String,
                    val `98114100`: String,
                    val `98114200`: String,
                    val `98114210`: String,
                    val `98114220`: String,
                    val `98114300`: String,
                    val `98114400`: String,
                    val `98115300`: String,
                    val `98116000`: String,
                    val `98116100`: String,
                    val `98116200`: String,
                    val `99200300`: String,
                    val `9935300`: String,
                    val `9935310`: String,
                    val `99355100`: String,
                    val `99355200`: String,
                    val `99355300`: String,
                    val `99355400`: String,
                    val `99355500`: String,
                    val `99367000`: String,
                    val `99371100`: String,
                    val `9938980`: String,
                    val `9939580`: String,
                    val `99490000`: String,
                    val `99502300`: String,
                    val `99502600`: String
                )
            }
    
            data class CharaFigureForm(
                val `1`: X1,
                val `2`: X2,
                val `3`: X3,
                val `4`: X4,
                val `5`: X5
            ) {
                data class X1(
                    val ascension: Ascension,
                    val costume: Costume
                ) {
                    data class Ascension(
                        val `1`: String,
                        val `2`: String,
                        val `3`: String
                    )
    
                    data class Costume(
                        val `101230`: String
                    )
                }
    
                data class X2(
                    val ascension: Ascension,
                    val costume: Costume
                ) {
                    data class Ascension(
                        val `1`: String,
                        val `2`: String,
                        val `3`: String
                    )
    
                    data class Costume(
                        val `101230`: String
                    )
                }
    
                data class X3(
                    val ascension: Ascension
                ) {
                    data class Ascension(
                        val `1`: String,
                        val `2`: String,
                        val `3`: String
                    )
                }
    
                data class X4(
                    val ascension: Ascension
                ) {
                    data class Ascension(
                        val `1`: String,
                        val `2`: String,
                        val `3`: String
                    )
                }
    
                data class X5(
                    val ascension: Ascension
                ) {
                    data class Ascension(
                        val `1`: String,
                        val `2`: String,
                        val `3`: String
                    )
                }
            }
    
            class CharaFigureMulti
    
            data class CharaGraph(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `0`: String,
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                )
    
                data class Costume(
                    val `100130`: String,
                    val `100230`: String,
                    val `100530`: String,
                    val `100540`: String,
                    val `100830`: String,
                    val `100930`: String,
                    val `101230`: String,
                    val `102730`: String,
                    val `102830`: String,
                    val `102840`: String,
                    val `102850`: String,
                    val `102930`: String,
                    val `103330`: String,
                    val `103630`: String,
                    val `1100230`: String,
                    val `1100330`: String,
                    val `1100930`: String,
                    val `200130`: String,
                    val `200330`: String,
                    val `201530`: String,
                    val `202330`: String,
                    val `2300230`: String,
                    val `2300240`: String,
                    val `300430`: String,
                    val `301330`: String,
                    val `303030`: String,
                    val `303830`: String,
                    val `304030`: String,
                    val `400430`: String,
                    val `400830`: String,
                    val `401330`: String,
                    val `403530`: String,
                    val `500830`: String,
                    val `501830`: String,
                    val `502830`: String,
                    val `601830`: String,
                    val `601930`: String,
                    val `603330`: String,
                    val `603630`: String,
                    val `603640`: String,
                    val `700630`: String,
                    val `702730`: String,
                    val `702830`: String,
                    val `703630`: String,
                    val `800130`: String,
                    val `800140`: String,
                    val `800150`: String,
                    val `800160`: String,
                    val `900230`: String,
                    val `900730`: String,
                    val `900740`: String
                )
            }
    
            class CharaGraphChange
    
            class CharaGraphEx
    
            data class CharaGraphName(
                val ascension: Ascension
            ) {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                )
            }
    
            data class Commands(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String
                )
    
                data class Costume(
                    val `100130`: String,
                    val `100230`: String,
                    val `100530`: String,
                    val `100540`: String,
                    val `100830`: String,
                    val `100930`: String,
                    val `101230`: String,
                    val `102730`: String,
                    val `102830`: String,
                    val `102840`: String,
                    val `102850`: String,
                    val `102930`: String,
                    val `103330`: String,
                    val `103630`: String,
                    val `1100230`: String,
                    val `1100330`: String,
                    val `1100930`: String,
                    val `200130`: String,
                    val `200330`: String,
                    val `201530`: String,
                    val `202330`: String,
                    val `2300230`: String,
                    val `2300240`: String,
                    val `300430`: String,
                    val `301330`: String,
                    val `303030`: String,
                    val `303830`: String,
                    val `304030`: String,
                    val `400430`: String,
                    val `400830`: String,
                    val `401330`: String,
                    val `403530`: String,
                    val `500830`: String,
                    val `501830`: String,
                    val `502830`: String,
                    val `601830`: String,
                    val `601930`: String,
                    val `603330`: String,
                    val `603630`: String,
                    val `603640`: String,
                    val `700630`: String,
                    val `702730`: String,
                    val `702830`: String,
                    val `703630`: String,
                    val `800130`: String,
                    val `800140`: String,
                    val `800150`: String,
                    val `800160`: String,
                    val `900230`: String,
                    val `900730`: String,
                    val `900740`: String
                )
            }
    
            class EquipFace
    
            data class Faces(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `0`: String,
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                )
    
                data class Costume(
                    val `100130`: String,
                    val `100230`: String,
                    val `100530`: String,
                    val `100540`: String,
                    val `100830`: String,
                    val `100930`: String,
                    val `101230`: String,
                    val `102730`: String,
                    val `102830`: String,
                    val `102840`: String,
                    val `102850`: String,
                    val `102930`: String,
                    val `103330`: String,
                    val `103630`: String,
                    val `1100230`: String,
                    val `1100330`: String,
                    val `1100930`: String,
                    val `200130`: String,
                    val `200330`: String,
                    val `201530`: String,
                    val `202330`: String,
                    val `2300230`: String,
                    val `2300240`: String,
                    val `300430`: String,
                    val `301330`: String,
                    val `303030`: String,
                    val `303830`: String,
                    val `304030`: String,
                    val `400430`: String,
                    val `400830`: String,
                    val `401330`: String,
                    val `403530`: String,
                    val `500830`: String,
                    val `501830`: String,
                    val `502830`: String,
                    val `601830`: String,
                    val `601930`: String,
                    val `603330`: String,
                    val `603630`: String,
                    val `603640`: String,
                    val `700630`: String,
                    val `702730`: String,
                    val `702830`: String,
                    val `703630`: String,
                    val `800130`: String,
                    val `800140`: String,
                    val `800150`: String,
                    val `800160`: String,
                    val `900230`: String,
                    val `900730`: String,
                    val `900740`: String
                )
            }
    
            class FacesChange
    
            data class Image(
                val story: Story
            ) {
                data class Story(
                    val `0`: String,
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                )
            }
    
            data class NarrowFigure(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                )
    
                data class Costume(
                    val `100130`: String,
                    val `100230`: String,
                    val `100530`: String,
                    val `100540`: String,
                    val `100830`: String,
                    val `100930`: String,
                    val `101230`: String,
                    val `102730`: String,
                    val `102830`: String,
                    val `102840`: String,
                    val `102850`: String,
                    val `102930`: String,
                    val `103330`: String,
                    val `103630`: String,
                    val `1100230`: String,
                    val `1100330`: String,
                    val `1100930`: String,
                    val `200130`: String,
                    val `200330`: String,
                    val `201530`: String,
                    val `202330`: String,
                    val `2300230`: String,
                    val `2300240`: String,
                    val `300430`: String,
                    val `301330`: String,
                    val `303030`: String,
                    val `303830`: String,
                    val `304030`: String,
                    val `400430`: String,
                    val `400830`: String,
                    val `401330`: String,
                    val `403530`: String,
                    val `500830`: String,
                    val `501830`: String,
                    val `502830`: String,
                    val `601830`: String,
                    val `601930`: String,
                    val `603330`: String,
                    val `603630`: String,
                    val `603640`: String,
                    val `700630`: String,
                    val `702730`: String,
                    val `702830`: String,
                    val `703630`: String,
                    val `800130`: String,
                    val `800140`: String,
                    val `800150`: String,
                    val `800160`: String,
                    val `900230`: String,
                    val `900730`: String,
                    val `900740`: String
                )
            }
    
            class NarrowFigureChange
    
            data class SpriteModel(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `0`: String,
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String,
                    val `9`: String
                )
    
                data class Costume(
                    val `100130`: String,
                    val `100230`: String,
                    val `100530`: String,
                    val `100540`: String,
                    val `100830`: String,
                    val `100930`: String,
                    val `101230`: String,
                    val `102730`: String,
                    val `102830`: String,
                    val `102840`: String,
                    val `102850`: String,
                    val `102930`: String,
                    val `103330`: String,
                    val `103630`: String,
                    val `1100230`: String,
                    val `1100330`: String,
                    val `1100930`: String,
                    val `200130`: String,
                    val `200330`: String,
                    val `201530`: String,
                    val `202330`: String,
                    val `2300230`: String,
                    val `2300240`: String,
                    val `300430`: String,
                    val `301330`: String,
                    val `303030`: String,
                    val `303830`: String,
                    val `304030`: String,
                    val `400430`: String,
                    val `400830`: String,
                    val `401330`: String,
                    val `403530`: String,
                    val `500830`: String,
                    val `501830`: String,
                    val `502830`: String,
                    val `601830`: String,
                    val `601930`: String,
                    val `603330`: String,
                    val `603630`: String,
                    val `603640`: String,
                    val `700630`: String,
                    val `702730`: String,
                    val `702830`: String,
                    val `703630`: String,
                    val `800130`: String,
                    val `800140`: String,
                    val `800150`: String,
                    val `800160`: String,
                    val `900230`: String,
                    val `900730`: String,
                    val `900740`: String
                )
            }
    
            data class Status(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String
                )
    
                data class Costume(
                    val `100130`: String,
                    val `100230`: String,
                    val `100530`: String,
                    val `100540`: String,
                    val `100830`: String,
                    val `100930`: String,
                    val `101230`: String,
                    val `102730`: String,
                    val `102830`: String,
                    val `102840`: String,
                    val `102850`: String,
                    val `102930`: String,
                    val `103330`: String,
                    val `103630`: String,
                    val `1100230`: String,
                    val `1100330`: String,
                    val `1100930`: String,
                    val `200130`: String,
                    val `200330`: String,
                    val `201530`: String,
                    val `202330`: String,
                    val `2300230`: String,
                    val `2300240`: String,
                    val `300430`: String,
                    val `301330`: String,
                    val `303030`: String,
                    val `303830`: String,
                    val `304030`: String,
                    val `400430`: String,
                    val `400830`: String,
                    val `401330`: String,
                    val `403530`: String,
                    val `500830`: String,
                    val `501830`: String,
                    val `502830`: String,
                    val `601830`: String,
                    val `601930`: String,
                    val `603330`: String,
                    val `603630`: String,
                    val `603640`: String,
                    val `700630`: String,
                    val `702730`: String,
                    val `702830`: String,
                    val `703630`: String,
                    val `800130`: String,
                    val `800140`: String,
                    val `800150`: String,
                    val `800160`: String,
                    val `900230`: String,
                    val `900730`: String,
                    val `900740`: String
                )
            }
        }
    
        data class ExtraPassive(
            val actIndividuality: List<Any>,
            val coolDown: List<Int>,
            val detail: String,
            val extraPassive: List<ExtraPassive>,
            val functions: List<Function>,
            val icon: String,
            val id: Int,
            val name: String,
            val originalName: String,
            val ruby: String,
            val script: Script,
            val skillAdd: List<Any>,
            val type: String,
            val unmodifiedDetail: String
        ) {
            data class ExtraPassive(
                val condFriendshipRank: Int,
                val condLimitCount: Int,
                val condLv: Int,
                val condQuestId: Int,
                val condQuestPhase: Int,
                val endedAt: Int,
                val eventId: Int,
                val flag: Int,
                val num: Int,
                val priority: Int,
                val startedAt: Int
            )
    
            data class Function(
                val buffs: List<Buff>,
                val funcGroup: List<FuncGroup>,
                val funcId: Int,
                val funcPopupIcon: String,
                val funcPopupText: String,
                val funcTargetTeam: String,
                val funcTargetType: String,
                val funcType: String,
                val funcquestTvals: List<FuncquestTval>,
                val functvals: List<Any>,
                val svals: List<Sval>,
                val traitVals: List<Any>
            ) {
                data class Buff(
                    val buffGroup: Int,
                    val ckOpIndv: List<Any>,
                    val ckSelfIndv: List<Any>,
                    val detail: String,
                    val icon: String,
                    val id: Int,
                    val maxRate: Int,
                    val name: String,
                    val script: Script,
                    val tvals: List<Any>,
                    val type: String,
                    val vals: List<Val>
                ) {
                    class Script
    
                    data class Val(
                        val id: Int,
                        val name: String
                    )
                }
    
                data class FuncGroup(
                    val baseFuncId: Int,
                    val eventId: Int,
                    val icon: String,
                    val isDispValue: Boolean,
                    val name: String,
                    val nameTotal: String,
                    val priority: Int
                )
    
                data class FuncquestTval(
                    val id: Int,
                    val name: String
                )
    
                data class Sval(
                    val AddCount: Int,
                    val ApplySupportSvt: Int,
                    val Count: Int,
                    val EventId: Int,
                    val Individuality: Int,
                    val Rate: Int,
                    val RateCount: Int,
                    val ShowState: Int,
                    val Target: Int,
                    val Turn: Int,
                    val Value: Int
                )
            }
    
            class Script
        }
    
        data class HitsDistribution(
            val arts: List<Int>,
            val buster: List<Int>,
            val extra: List<Int>,
            val quick: List<Int>
        )
    
        data class NoblePhantasm(
            val card: String,
            val condQuestId: Int,
            val condQuestPhase: Int,
            val detail: String,
            val effectFlags: List<String>,
            val functions: List<Function>,
            val icon: String,
            val id: Int,
            val individuality: List<Individuality>,
            val name: String,
            val npDistribution: List<Int>,
            val npGain: NpGain,
            val num: Int,
            val originalName: String,
            val priority: Int,
            val rank: String,
            val ruby: String,
            val script: Script,
            val strengthStatus: Int,
            val type: String,
            val unmodifiedDetail: String
        ) {
            data class Function(
                val buffs: List<Buff>,
                val funcGroup: List<Any>,
                val funcId: Int,
                val funcPopupIcon: String,
                val funcPopupText: String,
                val funcTargetTeam: String,
                val funcTargetType: String,
                val funcType: String,
                val funcquestTvals: List<FuncquestTval>,
                val functvals: List<Functval>,
                val svals: List<Sval>,
                val svals2: List<Svals2>,
                val svals3: List<Svals3>,
                val svals4: List<Svals4>,
                val svals5: List<Svals5>,
                val traitVals: List<TraitVal>
            ) {
                data class Buff(
                    val buffGroup: Int,
                    val ckOpIndv: List<CkOpIndv>,
                    val ckSelfIndv: List<CkSelfIndv>,
                    val detail: String,
                    val icon: String,
                    val id: Int,
                    val maxRate: Int,
                    val name: String,
                    val script: Script,
                    val tvals: List<Tval>,
                    val type: String,
                    val vals: List<Val>
                ) {
                    data class CkOpIndv(
                        val id: Int,
                        val name: String
                    )
    
                    data class CkSelfIndv(
                        val id: Int,
                        val name: String
                    )
    
                    data class Script(
                        val checkIndvType: Int,
                        val relationId: RelationId
                    ) {
                        data class RelationId(
                            val atkSide: AtkSide,
                            val defSide: DefSide
                        ) {
                            class AtkSide
    
                            data class DefSide(
                                val alterEgo: AlterEgo,
                                val archer: Archer,
                                val assassin: Assassin,
                                val avenger: Avenger,
                                val beastI: BeastI,
                                val beastUnknown: BeastUnknown,
                                val berserker: Berserker,
                                val caster: Caster,
                                val demonGodPillar: DemonGodPillar,
                                val foreigner: Foreigner,
                                val lancer: Lancer,
                                val moonCancer: MoonCancer,
                                val rider: Rider,
                                val ruler: Ruler,
                                val saber: Saber,
                                val shielder: Shielder
                            ) {
                                data class AlterEgo(
                                    val assassin: Assassin,
                                    val berserker: Berserker,
                                    val caster: Caster,
                                    val foreigner: Foreigner,
                                    val rider: Rider,
                                    val ruler: Ruler
                                ) {
                                    data class Assassin(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Caster(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Foreigner(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Rider(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Ruler(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Archer(
                                    val alterEgo: AlterEgo,
                                    val archer: Archer,
                                    val assassin: Assassin,
                                    val avenger: Avenger,
                                    val berserker: Berserker,
                                    val caster: Caster,
                                    val foreigner: Foreigner,
                                    val lancer: Lancer,
                                    val moonCancer: MoonCancer,
                                    val rider: Rider,
                                    val ruler: Ruler,
                                    val saber: Saber
                                ) {
                                    data class AlterEgo(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Archer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Assassin(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Avenger(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Caster(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Foreigner(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Lancer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class MoonCancer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Rider(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Ruler(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Saber(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Assassin(
                                    val alterEgo: AlterEgo,
                                    val berserker: Berserker,
                                    val rider: Rider
                                ) {
                                    data class AlterEgo(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Rider(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Avenger(
                                    val berserker: Berserker,
                                    val ruler: Ruler
                                ) {
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Ruler(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class BeastI(
                                    val archer: Archer,
                                    val berserker: Berserker,
                                    val lancer: Lancer,
                                    val saber: Saber
                                ) {
                                    data class Archer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Lancer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Saber(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class BeastUnknown(
                                    val alterEgo: AlterEgo,
                                    val archer: Archer,
                                    val assassin: Assassin,
                                    val avenger: Avenger,
                                    val berserker: Berserker,
                                    val caster: Caster,
                                    val foreigner: Foreigner,
                                    val lancer: Lancer,
                                    val moonCancer: MoonCancer,
                                    val rider: Rider,
                                    val ruler: Ruler,
                                    val saber: Saber,
                                    val shielder: Shielder
                                ) {
                                    data class AlterEgo(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Archer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Assassin(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Avenger(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Caster(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Foreigner(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Lancer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class MoonCancer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Rider(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Ruler(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Saber(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Shielder(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Berserker(
                                    val alterEgo: AlterEgo,
                                    val archer: Archer,
                                    val assassin: Assassin,
                                    val avenger: Avenger,
                                    val berserker: Berserker,
                                    val caster: Caster,
                                    val lancer: Lancer,
                                    val moonCancer: MoonCancer,
                                    val rider: Rider,
                                    val ruler: Ruler,
                                    val saber: Saber
                                ) {
                                    data class AlterEgo(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Archer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Assassin(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Avenger(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Caster(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Lancer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class MoonCancer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Rider(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Ruler(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Saber(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Caster(
                                    val assassin: Assassin,
                                    val berserker: Berserker
                                ) {
                                    data class Assassin(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class DemonGodPillar(
                                    val archer: Archer,
                                    val berserker: Berserker,
                                    val lancer: Lancer,
                                    val saber: Saber
                                ) {
                                    data class Archer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Lancer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Saber(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Foreigner(
                                    val berserker: Berserker,
                                    val foreigner: Foreigner
                                ) {
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Foreigner(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Lancer(
                                    val archer: Archer,
                                    val berserker: Berserker
                                ) {
                                    data class Archer(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class MoonCancer(
                                    val avenger: Avenger,
                                    val berserker: Berserker
                                ) {
                                    data class Avenger(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Rider(
                                    val berserker: Berserker,
                                    val caster: Caster
                                ) {
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Caster(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Ruler(
                                    val berserker: Berserker,
                                    val moonCancer: MoonCancer
                                ) {
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class MoonCancer(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Saber(
                                    val berserker: Berserker,
                                    val lancer: Lancer
                                ) {
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Lancer(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Shielder(
                                    val berserker: Berserker
                                ) {
                                    data class Berserker(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
                            }
                        }
                    }
    
                    data class Tval(
                        val id: Int,
                        val name: String
                    )
    
                    data class Val(
                        val id: Int,
                        val name: String
                    )
                }
    
                data class FuncquestTval(
                    val id: Int,
                    val name: String
                )
    
                data class Functval(
                    val id: Int,
                    val name: String
                )
    
                data class Sval(
                    val AddIndividualty: Int,
                    val AddLinkageTargetIndividualty: Int,
                    val CheckDead: Int,
                    val Correction: Int,
                    val Count: Int,
                    val HideMiss: Int,
                    val HideNoEffect: Int,
                    val IncludeIgnoreIndividuality: Int,
                    val ParamAddMaxCount: Int,
                    val Rate: Int,
                    val RatioHPLow: Int,
                    val ShowQuestNoEffect: Int,
                    val ShowState: Int,
                    val Target: Int,
                    val TargetIndiv: Int,
                    val TargetList: List<Int>,
                    val TargetRarityList: List<Int>,
                    val Turn: Int,
                    val UseRate: Int,
                    val Value: Int,
                    val Value2: Int
                )
    
                data class Svals2(
                    val AddIndividualty: Int,
                    val AddLinkageTargetIndividualty: Int,
                    val CheckDead: Int,
                    val Correction: Int,
                    val Count: Int,
                    val HideMiss: Int,
                    val HideNoEffect: Int,
                    val IncludeIgnoreIndividuality: Int,
                    val ParamAddMaxCount: Int,
                    val Rate: Int,
                    val RatioHPLow: Int,
                    val ShowQuestNoEffect: Int,
                    val ShowState: Int,
                    val Target: Int,
                    val TargetIndiv: Int,
                    val TargetList: List<Int>,
                    val TargetRarityList: List<Int>,
                    val Turn: Int,
                    val UseRate: Int,
                    val Value: Int,
                    val Value2: Int
                )
    
                data class Svals3(
                    val AddIndividualty: Int,
                    val AddLinkageTargetIndividualty: Int,
                    val CheckDead: Int,
                    val Correction: Int,
                    val Count: Int,
                    val HideMiss: Int,
                    val HideNoEffect: Int,
                    val IncludeIgnoreIndividuality: Int,
                    val ParamAddMaxCount: Int,
                    val Rate: Int,
                    val RatioHPLow: Int,
                    val ShowQuestNoEffect: Int,
                    val ShowState: Int,
                    val Target: Int,
                    val TargetIndiv: Int,
                    val TargetList: List<Int>,
                    val TargetRarityList: List<Int>,
                    val Turn: Int,
                    val UseRate: Int,
                    val Value: Int,
                    val Value2: Int
                )
    
                data class Svals4(
                    val AddIndividualty: Int,
                    val AddLinkageTargetIndividualty: Int,
                    val CheckDead: Int,
                    val Correction: Int,
                    val Count: Int,
                    val HideMiss: Int,
                    val HideNoEffect: Int,
                    val IncludeIgnoreIndividuality: Int,
                    val ParamAddMaxCount: Int,
                    val Rate: Int,
                    val RatioHPLow: Int,
                    val ShowQuestNoEffect: Int,
                    val ShowState: Int,
                    val Target: Int,
                    val TargetIndiv: Int,
                    val TargetList: List<Int>,
                    val TargetRarityList: List<Int>,
                    val Turn: Int,
                    val UseRate: Int,
                    val Value: Int,
                    val Value2: Int
                )
    
                data class Svals5(
                    val AddIndividualty: Int,
                    val AddLinkageTargetIndividualty: Int,
                    val CheckDead: Int,
                    val Correction: Int,
                    val Count: Int,
                    val HideMiss: Int,
                    val HideNoEffect: Int,
                    val IncludeIgnoreIndividuality: Int,
                    val ParamAddMaxCount: Int,
                    val Rate: Int,
                    val RatioHPLow: Int,
                    val ShowQuestNoEffect: Int,
                    val ShowState: Int,
                    val Target: Int,
                    val TargetIndiv: Int,
                    val TargetList: List<Int>,
                    val TargetRarityList: List<Int>,
                    val Turn: Int,
                    val UseRate: Int,
                    val Value: Int,
                    val Value2: Int
                )
    
                data class TraitVal(
                    val id: Int,
                    val name: String
                )
            }
    
            data class Individuality(
                val id: Int,
                val name: String
            )
    
            data class NpGain(
                val arts: List<Int>,
                val buster: List<Int>,
                val defence: List<Int>,
                val extra: List<Int>,
                val np: List<Int>,
                val quick: List<Int>
            )
    
            data class Script(
                val excludeTdChangeTypes: List<Int>,
                val tdTypeChangeIDs: List<Int>
            )
        }
    
        data class Script(
            val skillRankUp: SkillRankUp
        ) {
            data class SkillRankUp(
                val `682450`: List<Int>,
                val `767650`: List<Any>,
                val `768550`: List<Int>
            )
        }
    
        data class SkillMaterials(
            val `1`: X1,
            val `2`: X2,
            val `3`: X3,
            val `4`: X4,
            val `5`: X5,
            val `6`: X6,
            val `7`: X7,
            val `8`: X8,
            val `9`: X9
        ) {
            data class X1(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X2(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X3(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
    
            data class X4(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X5(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X6(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X7(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X8(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Individuality>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    ) {
                        data class Individuality(
                            val id: Int,
                            val name: String
                        )
                    }
                }
            }
    
            data class X9(
                val items: List<Item>,
                val qp: Int
            ) {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) {
                    data class Item(
                        val background: String,
                        val detail: String,
                        val dropPriority: Int,
                        val icon: String,
                        val id: Int,
                        val individuality: List<Any>,
                        val itemSelects: List<Any>,
                        val name: String,
                        val originalName: String,
                        val priority: Int,
                        val type: String,
                        val uses: List<String>
                    )
                }
            }
        }
    
        data class Skill(
            val actIndividuality: List<Any>,
            val aiIds: AiIds,
            val condLimitCount: Int,
            val condLv: Int,
            val condQuestId: Int,
            val condQuestPhase: Int,
            val coolDown: List<Int>,
            val detail: String,
            val extraPassive: List<Any>,
            val functions: List<Function>,
            val icon: String,
            val id: Int,
            val name: String,
            val num: Int,
            val originalName: String,
            val priority: Int,
            val ruby: String,
            val script: Script,
            val skillAdd: List<Any>,
            val strengthStatus: Int,
            val type: String,
            val unmodifiedDetail: String
        ) {
            data class AiIds(
                val `field`: List<Any>,
                val svt: List<Int>
            )
    
            data class Function(
                val buffs: List<Buff>,
                val funcGroup: List<Any>,
                val funcId: Int,
                val funcPopupIcon: String,
                val funcPopupText: String,
                val funcTargetTeam: String,
                val funcTargetType: String,
                val funcType: String,
                val funcquestTvals: List<FuncquestTval>,
                val functvals: List<Functval>,
                val svals: List<Sval>,
                val traitVals: List<TraitVal>
            ) {
                data class Buff(
                    val buffGroup: Int,
                    val ckOpIndv: List<CkOpIndv>,
                    val ckSelfIndv: List<CkSelfIndv>,
                    val detail: String,
                    val icon: String,
                    val id: Int,
                    val maxRate: Int,
                    val name: String,
                    val script: Script,
                    val tvals: List<Tval>,
                    val type: String,
                    val vals: List<Val>
                ) {
                    data class CkOpIndv(
                        val id: Int,
                        val name: String
                    )
    
                    data class CkSelfIndv(
                        val id: Int,
                        val name: String
                    )
    
                    data class Script(
                        val DamageRelease: Int,
                        val HP_LOWER: Int,
                        val iNDIVIDUALITIE: INDIVIDUALITIE,
                        val ReleaseText: String,
                        val checkIndvType: Int,
                        val relationId: RelationId
                    ) {
                        data class INDIVIDUALITIE(
                            val id: Int,
                            val name: String
                        )
    
                        data class RelationId(
                            val atkSide: AtkSide,
                            val defSide: DefSide
                        ) {
                            data class AtkSide(
                                val assassin: Assassin
                            ) {
                                data class Assassin(
                                    val alterEgo: AlterEgo,
                                    val caster: Caster
                                ) {
                                    data class AlterEgo(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Caster(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
                            }
    
                            data class DefSide(
                                val alterEgo: AlterEgo,
                                val archer: Archer,
                                val berserker: Berserker,
                                val caster: Caster,
                                val rider: Rider,
                                val saber: Saber
                            ) {
                                data class AlterEgo(
                                    val assassin: Assassin,
                                    val caster: Caster
                                ) {
                                    data class Assassin(
                                        val damageRate: Int,
                                        val type: String
                                    )
    
                                    data class Caster(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Archer(
                                    val caster: Caster
                                ) {
                                    data class Caster(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Berserker(
                                    val caster: Caster
                                ) {
                                    data class Caster(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Caster(
                                    val assassin: Assassin
                                ) {
                                    data class Assassin(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Rider(
                                    val caster: Caster
                                ) {
                                    data class Caster(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
    
                                data class Saber(
                                    val caster: Caster
                                ) {
                                    data class Caster(
                                        val damageRate: Int,
                                        val type: String
                                    )
                                }
                            }
                        }
                    }
    
                    data class Tval(
                        val id: Int,
                        val name: String
                    )
    
                    data class Val(
                        val id: Int,
                        val name: String
                    )
                }
    
                data class FuncquestTval(
                    val id: Int,
                    val name: String
                )
    
                data class Functval(
                    val id: Int,
                    val name: String
                )
    
                data class Sval(
                    val ActSet: Int,
                    val ActSetWeight: Int,
                    val AddIndividualty: Int,
                    val AddLinkageTargetIndividualty: Int,
                    val AuraEffectId: Int,
                    val Count: Int,
                    val DependFuncId: Int,
                    val dependFuncVals: DependFuncVals,
                    val HideMiss: Int,
                    val HideNoEffect: Int,
                    val InvalidHide: Int,
                    val MotionChange: Int,
                    val ParamAdd: Int,
                    val ParamMax: Int,
                    val Rate: Int,
                    val RatioHPHigh: Int,
                    val RatioHPLow: Int,
                    val RatioHPRangeHigh: Int,
                    val RatioHPRangeLow: Int,
                    val ShowCardOnly: Int,
                    val ShowQuestNoEffect: Int,
                    val ShowState: Int,
                    val SkillID: Int,
                    val SkillLV: Int,
                    val StarHigher: Int,
                    val Turn: Int,
                    val UseRate: Int,
                    val Value: Int,
                    val Value2: Int
                ) {
                    data class DependFuncVals(
                        val Rate: Int,
                        val Value: Int,
                        val Value2: Int
                    )
                }
    
                data class TraitVal(
                    val id: Int,
                    val name: String
                )
            }
    
            data class Script(
                val HP_PER_LOWER: List<Int>,
                val HP_VAL_HIGHER: List<Int>,
                val NP_HIGHER: List<Int>,
                val STAR_HIGHER: List<Int>
            )
        }
    
        data class SvtChange(
            val afterTreasureDeviceIds: List<Int>,
            val battleName: String,
            val battleSvtId: Int,
            val beforeTreasureDeviceIds: List<Int>,
            val condTargetId: Int,
            val condType: String,
            val condValue: Int,
            val flag: Int,
            val limitCount: Int,
            val name: String,
            val priority: Int,
            val ruby: String,
            val svtId: Int,
            val svtVoiceId: Int
        )
    
        data class TraitAdd(
            val condId: Int,
            val condNum: Int,
            val condType: String,
            val idx: Int,
            val limitCount: Int,
            val trait: List<Trait>
        ) {
            data class Trait(
                val id: Int,
                val name: String
            )
        }
    
        data class Trait(
            val id: Int,
            val name: String
        )
    
        data class ValentineScript(
            val script: String,
            val scriptId: String,
            val scriptName: String
        )
    }
}