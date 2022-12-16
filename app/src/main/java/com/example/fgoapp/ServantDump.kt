package com.example.fgoapp

import java.io.Serializable

class ServantDump : ArrayList<ServantDump.ServantDumpItem>() , Serializable{
    data class ServantDumpItem(
        val appendPassive: List<AppendPassive>,
        val appendSkillMaterials: AppendSkillMaterials,
        val ascensionAdd: AscensionAdd,
        val ascensionImage: List<Any>,
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
        val svtChange: List<Any>,
        val traitAdd: List<TraitAdd>,
        val traits: List<Trait>,
        val trialQuestIds: List<Any>,
        val type: String,
        val valentineEquip: List<Int>,
        val valentineScript: List<ValentineScript>
    ) : Serializable {
        data class AppendPassive(
            val num: Int,
            val priority: Int,
            val skill: Skill,
            val unlockMaterials: List<UnlockMaterial>
        ) : Serializable {
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
            ) : Serializable {
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
                ) : Serializable {
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
                    ) : Serializable {
                        data class CkOpIndv(
                            val id: Int,
                            val name: String
                        ) : Serializable
    
                        data class CkSelfIndv(
                            val id: Int,
                            val name: String
                        ) : Serializable
    
                        class Script : Serializable
    
                        data class Tval(
                            val id: Int,
                            val name: String
                        ) : Serializable
    
                        data class Val(
                            val id: Int,
                            val name: String
                        ) : Serializable
                    }
    
                    data class Sval(
                        val Count: Int,
                        val Rate: Int,
                        val ShowState: Int,
                        val Turn: Int,
                        val Value: Int
                    ) : Serializable
                }
    
                class Script : Serializable
            }
    
            data class UnlockMaterial(
                val amount: Int,
                val item: Item
            ) : Serializable {
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
                ) : Serializable
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
        ) : Serializable {
            data class X1(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X2(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X3(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X4(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X5(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X6(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X7(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X8(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X9(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
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
        ) : Serializable {
            data class CharaGraphChange(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class CharaGraphChangeCommonRelease(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class FaceChange(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class FaceChangeCommonRelease(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class Individuality(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                data class Costume(
                    val `100130`: List<Any>
                ) : Serializable
            }
    
            data class LvMax(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                data class Ascension(
                    val `0`: Int,
                    val `1`: Int,
                    val `2`: Int,
                    val `3`: Int,
                    val `4`: Int
                ) : Serializable
    
                class Costume : Serializable
            }
    
            data class OriginalOverWriteServantBattleName(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class OriginalOverWriteServantName(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class OriginalOverWriteTDName(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class OverWriteServantBattleName(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class OverWriteServantName(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class OverWriteTDFileName(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class OverWriteTDName(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class OverWriteTDRank(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class OverWriteTDRuby(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class OverWriteTDTypeText(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                class Costume : Serializable
            }
    
            data class VoicePrefix(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                class Ascension : Serializable
    
                data class Costume(
                    val `100130`: Int
                ) : Serializable
            }
        }
    
        data class AscensionMaterials(
            val `0`: X0,
            val `1`: X1,
            val `2`: X2,
            val `3`: X3
        ) : Serializable {
            data class X0(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X1(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X2(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X3(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
        }
    
        data class CardDetails(
            val arts: Arts,
            val buster: Buster,
            val extra: Extra,
            val quick: Quick
        ) : Serializable {
            data class Arts(
                val attackIndividuality: List<AttackIndividuality>
            ) : Serializable {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                ) : Serializable
            }
    
            data class Buster(
                val attackIndividuality: List<AttackIndividuality>
            ) : Serializable {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                ) : Serializable
            }
    
            data class Extra(
                val attackIndividuality: List<AttackIndividuality>
            ) : Serializable {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                ) : Serializable
            }
    
            data class Quick(
                val attackIndividuality: List<AttackIndividuality>
            ) : Serializable {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                ) : Serializable
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
        ) : Serializable {
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
            ) : Serializable {
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
                ) : Serializable {
                    data class CkOpIndv(
                        val id: Int,
                        val name: String
                    ) : Serializable
    
                    data class CkSelfIndv(
                        val id: Int,
                        val name: String
                    ) : Serializable
    
                    class Script : Serializable
    
                    data class Tval(
                        val id: Int,
                        val name: String
                    ) : Serializable
    
                    data class Val(
                        val id: Int,
                        val name: String
                    ) : Serializable
                }
    
                data class Sval(
                    val Count: Int,
                    val Rate: Int,
                    val Turn: Int,
                    val Value: Int
                ) : Serializable
            }
    
            class Script : Serializable
        }
    
        data class Coin(
            val item: Item,
            val summonNum: Int
        ) : Serializable {
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
            ) : Serializable
        }
    
        data class CostumeMaterials(
            val `100130`: X100130
        ) : Serializable {
            data class X100130(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
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
        ) : Serializable {
            data class CharaFigure(
                val ascension: Ascension,
                val costume: Costume,
                val story: Story
            ) : Serializable {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String
                ) : Serializable
    
                data class Costume(
                    val `100130`: String
                ) : Serializable
    
                data class Story(
                    val `98060000`: String
                ) : Serializable
            }
    
            class CharaFigureForm : Serializable
    
            class CharaFigureMulti : Serializable
    
            data class CharaGraph(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                ) : Serializable
    
                data class Costume(
                    val `100130`: String
                ) : Serializable
            }
    
            class CharaGraphChange : Serializable
    
            class CharaGraphEx : Serializable
    
            class CharaGraphName : Serializable
    
            data class Commands(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String
                ) : Serializable
    
                data class Costume(
                    val `100130`: String
                ) : Serializable
            }
    
            class EquipFace : Serializable
    
            data class Faces(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                ) : Serializable
    
                data class Costume(
                    val `100130`: String
                ) : Serializable
            }
    
            class FacesChange : Serializable
    
            data class Image(
                val story: Story
            ) : Serializable {
                class Story : Serializable
            }
    
            data class NarrowFigure(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String,
                    val `4`: String
                ) : Serializable
    
                data class Costume(
                    val `100130`: String
                ) : Serializable
            }
    
            class NarrowFigureChange : Serializable
    
            data class SpriteModel(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                data class Ascension(
                    val `0`: String
                ) : Serializable
    
                data class Costume(
                    val `100130`: String
                ) : Serializable
            }
    
            data class Status(
                val ascension: Ascension,
                val costume: Costume
            ) : Serializable {
                data class Ascension(
                    val `1`: String,
                    val `2`: String,
                    val `3`: String
                ) : Serializable
    
                data class Costume(
                    val `100130`: String
                ) : Serializable
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
        ) : Serializable {
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
            ) : Serializable
    
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
                val svals: List<Sval>
            ) : Serializable {
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
                ) : Serializable {
                    class Script : Serializable
    
                    data class Val(
                        val id: Int,
                        val name: String
                    ) : Serializable
                }
    
                data class FuncGroup(
                    val baseFuncId: Int,
                    val eventId: Int,
                    val icon: String,
                    val isDispValue: Boolean,
                    val name: String,
                    val nameTotal: String,
                    val priority: Int
                ) : Serializable
    
                data class FuncquestTval(
                    val id: Int,
                    val name: String
                ) : Serializable
    
                data class Sval(
                    val Count: Int,
                    val EventId: Int,
                    val Individuality: Int,
                    val Rate: Int,
                    val RateCount: Int,
                    val ShowState: Int,
                    val Target: Int,
                    val Turn: Int,
                    val Value: Int
                ) : Serializable
            }
    
            class Script : Serializable
        }
    
        data class HitsDistribution(
            val arts: List<Int>,
            val buster: List<Int>,
            val extra: List<Int>,
            val quick: List<Int>
        ) : Serializable
    
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
        ) : Serializable {
            data class Function(
                 val buffs: List<Any>,
                val funcGroup: List<Any>,
                val funcId: Int,
                val funcPopupText: String,
                val funcTargetTeam: String,
                val funcTargetType: String,
                val funcType: String,
                val funcquestTvals: List<Any>,
                val functvals: List<Any>,
                val svals: List<Sval>,
                val svals2: List<Svals2>,
                val svals3: List<Svals3>,
                val svals4: List<Svals4>,
                val svals5: List<Svals5>
            ) : Serializable {
                data class Sval(
                    val Rate: Int,
                    val Value: Int
                ) : Serializable
    
                data class Svals2(
                    val Rate: Int,
                    val Value: Int
                ) : Serializable
    
                data class Svals3(
                    val Rate: Int,
                    val Value: Int
                ) : Serializable
    
                data class Svals4(
                    val Rate: Int,
                    val Value: Int
                ) : Serializable
    
                data class Svals5(
                    val Rate: Int,
                    val Value: Int
                ) : Serializable
            }
    
            data class Individuality(
                val id: Int,
                val name: String
            ) : Serializable
    
            data class NpGain(
                val arts: List<Int>,
                val buster: List<Int>,
                val defence: List<Int>,
                val extra: List<Int>,
                val np: List<Int>,
                val quick: List<Int>
            ) : Serializable
    
            class Script : Serializable
        }
    
        class Script : Serializable
    
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
        ) : Serializable {
            data class X1(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X2(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X3(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X4(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X5(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X6(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X7(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X8(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
    
            data class X9(
                val items: List<Item>,
                val qp: Int
            ) : Serializable {
                data class Item(
                    val amount: Int,
                    val item: Item
                ) : Serializable {
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
                    ) : Serializable
                }
            }
        }
    
        data class Skill(
            val actIndividuality: List<Any>,
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
        ) : Serializable {
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
            ) : Serializable {
                data class Buff(
                    val buffGroup: Int,
                    val ckOpIndv: List<Any>,
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
                ) : Serializable {
                    data class CkSelfIndv(
                        val id: Int,
                        val name: String
                    ) : Serializable
    
                    class Script : Serializable
    
                    data class Tval(
                        val id: Int,
                        val name: String
                    ) : Serializable
    
                    data class Val(
                        val id: Int,
                        val name: String
                    ) : Serializable
                }
    
                data class Sval(
                    val Count: Int,
                    val MotionChange: Int,
                    val Rate: Int,
                    val Turn: Int,
                    val Value: Int
                ) : Serializable
            }
    
            class Script : Serializable
        }
    
        data class TraitAdd(
            val condId: Int,
            val condNum: Int,
            val condType: String,
            val idx: Int,
            val limitCount: Int,
            val trait: List<Trait>
        ) : Serializable {
            data class Trait(
                val id: Int,
                val name: String
            ) : Serializable
        }
    
        data class Trait(
            val id: Int,
            val name: String
        ) : Serializable
    
        data class ValentineScript(
            val script: String,
            val scriptId: String,
            val scriptName: String
        ) : Serializable
    }
}