/*
 * NoCreeperHoles
 * Copyright (C) 2021 Valoeghese
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package valoeghese.nocreeperholes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.BooleanRule;

public class Nocreeperholes implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("Nocreeperholes");

	public static GameRules.Key<BooleanRule> creeperGriefing;
	public static GameRules.Key<BooleanRule> creeperFire;
	public static GameRules.Key<BooleanRule> ghastGriefing;
	public static GameRules.Key<BooleanRule> ghastFire;
	public static GameRules.Key<BooleanRule> endermanGriefing;
	public static GameRules.Key<BooleanRule> witherGriefing;
	public static GameRules.Key<BooleanRule> witherSpawnFire;
	public static GameRules.Key<BooleanRule> witherSkullFire;

	@Override
	public void onInitialize() {
		LOGGER.info("Adding a couple nifty gamerules~");

		// Fire/Griefing Rules
		creeperGriefing = GameRuleRegistry.register("creeperGriefing", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
		creeperFire = GameRuleRegistry.register("creeperFire", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));
		ghastGriefing = GameRuleRegistry.register("ghastGriefing", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
		ghastFire = GameRuleRegistry.register("ghastFire", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
		endermanGriefing = GameRuleRegistry.register("endermanGriefing", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
		witherGriefing = GameRuleRegistry.register("witherGriefing", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
		witherSpawnFire = GameRuleRegistry.register("witherSpawnFire", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));
		witherSkullFire = GameRuleRegistry.register("witherSkullFire", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));
	}
}
