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

package valoeghese.nocreeperholes.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import valoeghese.nocreeperholes.Nocreeperholes;

@Mixin(WitherSkullEntity.class)
public class MixinWitherSkull {
	@Redirect(
			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;createExplosion(Lnet/minecraft/entity/Entity;DDDFZLnet/minecraft/world/World$ExplosionSourceType;)Lnet/minecraft/world/explosion/Explosion;"),
			method = "onCollision")
	private Explosion redirectExplosion(World world, Entity entity, double x, double y, double z, float power, boolean createFire, World.ExplosionSourceType explosionSourceType) {
		GameRules gameRules = world.getGameRules();
		return world.createExplosion(
				entity,
				x,
				y,
				z,
				power,
				gameRules.getBoolean(GameRules.DO_MOB_GRIEFING) && gameRules.getBoolean(Nocreeperholes.witherSkullFire), // Continue Vanilla Behaviour as per ghast
				gameRules.getBoolean(Nocreeperholes.witherGriefing) ? explosionSourceType : World.ExplosionSourceType.NONE);
	}
}
