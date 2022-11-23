package com.example.fgoapp

class ServantDump : ArrayList<ServantDump.ServantDumpItem>(){
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
    
                        class Script
    
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
                class Ascension
    
                data class Costume(
                    val `100130`: List<Any>
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
                class Ascension
    
                class Costume
            }
    
            data class OriginalOverWriteServantName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
                class Costume
            }
    
            data class OriginalOverWriteTDName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
                class Costume
            }
    
            data class OverWriteServantBattleName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
                class Costume
            }
    
            data class OverWriteServantName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
                class Costume
            }
    
            data class OverWriteTDFileName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
                class Costume
            }
    
            data class OverWriteTDName(
                val ascension: Ascension,
                val costume: Costume
            ) {
                class Ascension
    
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
                class Ascension
    
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
                class Ascension
    
                data class Costume(
                    val `100130`: Int
                )
            }
        }
    
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
    
                    class Script
    
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
                    val Turn: Int,
                    val Value: Int
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
            val `100130`: X100130
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
                    val `100130`: String
                )
    
                data class Story(
                    val `98060000`: String
                )
            }
    
            class CharaFigureForm
    
            class CharaFigureMulti
    
            data class CharaGraph(
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
                    val `100130`: String
                )
            }
    
            class CharaGraphChange
    
            class CharaGraphEx
    
            class CharaGraphName
    
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
                    val `100130`: String
                )
            }
    
            class EquipFace
    
            data class Faces(
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
                    val `100130`: String
                )
            }
    
            class FacesChange
    
            data class Image(
                val story: Story
            ) {
                class Story
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
                    val `100130`: String
                )
            }
    
            class NarrowFigureChange
    
            data class SpriteModel(
                val ascension: Ascension,
                val costume: Costume
            ) {
                data class Ascension(
                    val `0`: String
                )
    
                data class Costume(
                    val `100130`: String
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
                    val `100130`: String
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
                val svals: List<Sval>
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
            ) {
                data class Sval(
                    val Rate: Int,
                    val Value: Int
                )
    
                data class Svals2(
                    val Rate: Int,
                    val Value: Int
                )
    
                data class Svals3(
                    val Rate: Int,
                    val Value: Int
                )
    
                data class Svals4(
                    val Rate: Int,
                    val Value: Int
                )
    
                data class Svals5(
                    val Rate: Int,
                    val Value: Int
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
    
            class Script
        }
    
        class Script
    
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
                ) {
                    data class CkSelfIndv(
                        val id: Int,
                        val name: String
                    )
    
                    class Script
    
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
                    val MotionChange: Int,
                    val Rate: Int,
                    val Turn: Int,
                    val Value: Int
                )
            }
    
            class Script
        }
    
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